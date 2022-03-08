package com.company;

import java.util.ArrayList;
import java.util.Random;

public class TrafficManager implements Runnable {
    private final ArrayList<TrafficLight> trafficLights = new ArrayList<>();

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void add() {
        add(1 + randomNumberGenerator.nextInt(5)); // between 1 and 5)
    }

//    // moves a bubble in an open space
//    private void place(TrafficLight trafficLight) {
//        int radius = trafficLight.getRadius();
//        while (true) {
//            //trafficLight.setX(radius + (width - 2 * radius) * randomNumberGenerator.nextFloat());
//            //trafficLight.setY(radius + (height - 2 * radius) * randomNumberGenerator.nextFloat());
//            boolean clean = true;
//            for (TrafficLight otherBubble : trafficLights) {
//                if (otherBubble != trafficLight && trafficLight.getDistance(otherBubble) <= 0) {
//                    clean = false;
//                    break;
//                }
//            }
//            if (clean) {
//                break;
//            }
//        }
//    }

    // adds bubbles.
    public void add(int adding) {
        int added = 0;
        synchronized (trafficLights) {
            while (added < adding) {
                int radius = 10;
                // int radius = 5 + randomNumberGenerator.nextInt(20); // between 5 and 24
                TrafficLight trafficLight = new TrafficLight(radius, (added + 1) * 200, height/2f);
                trafficLights.add(trafficLight);
                //trafficLight.setSpeedX((2 * randomNumberGenerator.nextFloat() - 1) * 50);
                //trafficLight.setSpeedY((2 * randomNumberGenerator.nextFloat() - 1) * 50);
                added += 1;
                System.out.println("Number of Traffic Lights = " + added);
                // place(trafficLight); // moves the bubble randomly
            }
        }
    }

//    // does the check for bounding and for bumping into other bubbles
//    private void move() {
//        synchronized (trafficLights) {
//            for (TrafficLight trafficLight : trafficLights) {
//                //trafficLight.updateColorAndSpokeAngle();
//                //float newX = trafficLight.getX() + deltaMilliseconds * trafficLight.getSpeedX() / 1000;
//                //float newY = trafficLight.getY() + deltaMilliseconds * trafficLight.getSpeedY() / 1000;
//                float radius = trafficLight.getRadius();
//                //trafficLight.setX(newX);
//                //trafficLight.setY(newY);
//                for (TrafficLight otherLight : trafficLights) {
//                    if (otherLight == trafficLight) {
//                        continue;
//                    }
//                    float distance = trafficLight.getDistance(otherLight);
//                    if (distance < 0) {
//                        place(trafficLight);
//                        break;
//                    }
//                }
////                if (newX - radius <= 0 || (newX + radius >= width)) {
////                    trafficLight.setSpeedX(-trafficLight.getSpeedX());
////                }
////                if (newY - radius <= 0 || (newY + radius >= height)) {
////                    trafficLight.setSpeedY(-trafficLight.getSpeedY());
////                }
//            }
//        }
//    }

    @Override
    public void run() {
        while (true) {
            try {
                //move();
                Thread.sleep(deltaMilliseconds);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
