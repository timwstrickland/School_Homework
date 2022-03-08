package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.print.attribute.standard.Chromaticity.COLOR;

@SuppressWarnings("serial")
public class TrafficDisplay extends JPanel {

    private final List<TrafficLight> trafficLights;
    private final List<Vehicle> vehicles;
    private final int trafficAreaWidth;
    private final int trafficAreaHeight;

    public TrafficDisplay(TrafficManager trafficManager) {
        super();
        trafficLights = trafficManager.getTrafficLights();
        vehicles = trafficManager.getVehicles();
        trafficAreaWidth = trafficManager.getWidth();
        trafficAreaHeight = trafficManager.getHeight();
        setMinimumSize(new Dimension(trafficAreaWidth, trafficAreaHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        float widthOffset = (getWidth() - trafficAreaWidth) / 2f;
        float heightOffset = (getHeight() - trafficAreaHeight) / 2f;
        graphics.setColor(Color.blue);
        graphics.fillRect((int) widthOffset, (int) heightOffset, trafficAreaWidth, trafficAreaHeight);

        //loops through the lights and draws them at current position.
        synchronized (trafficLights) {
            for(TrafficLight trafficLight: trafficLights) {
                draw(trafficLight, graphics);
            }
        }
        //loops through the vehicles and draws them at current position.
        synchronized (vehicles) {
            for(Vehicle vehicle: vehicles) {
                draw(vehicle, graphics);
            }
        }
    }
        //traffic light draw method which paints the lights and the text on the GUI.
    private void draw(TrafficLight trafficLight, Graphics graphics) {
        int diameter = trafficLight.getDiameter();
        int radius = trafficLight.getRadius();
        graphics.setColor(trafficLight.getColor());
        int x = (int) trafficLight.getX();
        int y = (int) trafficLight.getY();
        graphics.fillOval(x, y, diameter, diameter);
        graphics.fillRect(x + radius / 2, y + 30, 10, 50);
        graphics.setColor(Color.WHITE);
        String time = String.format("%.2f", trafficLight.getTimeRemaining()/1000);
        graphics.drawString(time + " seconds",
                (int) trafficLight.getX() - 30, (int) trafficLight.getY() - 20);
    }

    //vehicle draw method which paints the lights and the text on the GUI.
    private void draw(Vehicle vehicle, Graphics graphics) {
        int side = vehicle.getSide();
        graphics.setColor(vehicle.getColor());
        int x = (int) vehicle.getX();
        int y = (int) vehicle.getY();
        graphics.fillRect(x + side / 2, y + 75, side, side);
        graphics.setColor(Color.WHITE);
        graphics.drawString("" + vehicle.getCurrentSpeed() + " kph",
                (int) vehicle.getX() - 30, (int) vehicle.getY() + 95);
    }
}
