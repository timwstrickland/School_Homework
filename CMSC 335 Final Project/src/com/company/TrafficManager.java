package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TrafficManager implements Runnable {
    private final ArrayList<TrafficLight> trafficLights = new ArrayList<>();
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    private final int width;
    private final int height;
    private final Random randomNumberGenerator = new Random();
    private final long deltaMilliseconds;

    public TrafficManager(int width, int height, long deltaMilliseconds) {
        this.width = width;
        this.height = height;
        this.deltaMilliseconds = deltaMilliseconds;
    }

    public ArrayList<TrafficLight> getTrafficLights() {
        return trafficLights;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void add() {
        add(1 + randomNumberGenerator.nextInt(4)); // between 1 and 4)
    }

    public void add(int adding) {
        int added = 0;
        synchronized (vehicles) {
            while (added < adding) {
                int side = 20;
                Vehicle vehicle = new Vehicle(side, 30 + randomNumberGenerator.nextInt(400), height / 2f - (added * 20),
                        50 + randomNumberGenerator.nextInt(25));
                vehicles.add(vehicle);
                added += 1;
            }
            added = 0;
        }
        synchronized (trafficLights) {
            while (added < adding) {
                int radius = 10;
                TrafficLight trafficLight = new TrafficLight(radius, (added + 1) * 200, height/2f,
                        (1000 + (randomNumberGenerator.nextFloat(2000))));
                trafficLights.add(trafficLight);
                added += 1;
            }
        }
    }

// Check the color of lights
    private void checkTraffic() {
        synchronized (trafficLights) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.updateColor();
                trafficLight.setTimeRemaining((float) trafficLight.getTimeRemaining() - deltaMilliseconds);
            }
        }
        // Checks each vehicle to see if it must stop at a red light or not.
        synchronized (vehicles) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move(deltaMilliseconds);
                boolean stop = false;
                for (TrafficLight trafficLight: trafficLights) {
                    if(((vehicle.getX() + vehicle.getSide() >= trafficLight.getX() - trafficLight.getRadius()/2) &&
                    (vehicle.getX() <= trafficLight.getX() + trafficLight.getRadius()/2))
                            && trafficLight.getColor() == Color.RED) {
                        stop = true;
                    }
                }
                if(stop) {
                    vehicle.setCurrentSpeed(0);
                }
                else {
                    vehicle.setCurrentSpeed(vehicle.getInitialSpeed());
                }
            }
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                checkTraffic();
                Thread.sleep(deltaMilliseconds);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
