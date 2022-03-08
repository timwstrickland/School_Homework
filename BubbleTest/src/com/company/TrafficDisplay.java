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
    private final List<JLabel> trafficLightLabels;
    private final List<JLabel> vehicleLabels;
    private final int trafficAreaWidth;
    private final int trafficAreaHeight;

    public TrafficDisplay(TrafficManager trafficManager) {
        super();
        trafficLights = trafficManager.getTrafficLights();
        vehicles = trafficManager.getVehicles();
        trafficLightLabels = new ArrayList<JLabel>();
        vehicleLabels = new ArrayList<JLabel>();
        for (TrafficLight light : trafficLights) {
            int x = (int) light.getX();
            int y = (int) light.getY() - 30;
            JLabel label = new JLabel("sample");
            trafficLightLabels.add(label);
            this.add(label);
            label.setLocation(x, y);
        }

        for (Vehicle v: vehicles) {
            int x = (int) v.getX();
            int y = (int) v.getY() - 30;
            JLabel label = new JLabel("sample");
            vehicleLabels.add(label);
            this.add(label);
            label.setLocation(x, y);
        }
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
        // graphics.setColor(Color.red); used?
        synchronized (trafficLights) {
            for (int i = 0; i < trafficLights.size(); i++) {
                TrafficLight trafficLight = trafficLights.get(i);
                JLabel label = trafficLightLabels.get(i);
                draw(trafficLight, graphics);
                double time = trafficLight.getTimeRemaining() / 1000;
                label.setText(String.format("%.2f", time));
            }
            ;
        }

        synchronized (vehicles) {
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle = vehicles.get(i);
                JLabel label = vehicleLabels.get(i);
                draw(vehicle, graphics);
                float speed = vehicle.getCurrentSpeed();
                label.setText("Car " + i + " " + speed + "kph");
            }
        }
    }

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
//    private void draw(TrafficLight trafficLight, Graphics graphics, float widthOffset, float heightOffset) {
//        int diameter = trafficLight.getDiameter();
//        int radius = trafficLight.getRadius();
//        graphics.setColor(trafficLight.getColor());
//        graphics.drawOval((int) (widthOffset + trafficLight.getLeftX()), (int) (heightOffset + trafficLight.getTopY()), diameter,
//                diameter);
//        graphics.fillOval((int) (widthOffset + trafficLight.getLeftX() + radius / 2),
//                (int) (heightOffset + trafficLight.getTopY() + radius / 2), radius, radius);
        //float spokeAngle = trafficLight.getSpokeAngle();
        //double deltaX = radius * Math.cos(spokeAngle);
        //double deltaY = radius * Math.sin(spokeAngle);
//        graphics.drawLine((int) (widthOffset + trafficLight.getX() - deltaX), (int) (heightOffset + trafficLight.getY() - deltaY),
//                (int) (widthOffset + trafficLight.getX() + deltaX), (int) (heightOffset + trafficLight.getY() + deltaY));
//        graphics.drawLine((int) (widthOffset + trafficLight.getX() + deltaY), (int) (heightOffset + trafficLight.getY() - deltaX),
//                (int) (widthOffset + trafficLight.getX() - deltaY), (int) (heightOffset + trafficLight.getY() + deltaX));
    }

    private void draw(Vehicle vehicle, Graphics graphics) {
        int side = vehicle.getSide();
        //int radius = trafficLight.getRadius();
        graphics.setColor(vehicle.getColor());
        int x = (int) vehicle.getX();
        int y = (int) vehicle.getY();
        graphics.fillRect(x + side / 2, y + 75, side, side);
        graphics.setColor(Color.WHITE);
        graphics.drawString("" + vehicle.getCurrentSpeed() + " kph",
                (int) vehicle.getX() - 30, (int) vehicle.getY() + 95);
    }
}
