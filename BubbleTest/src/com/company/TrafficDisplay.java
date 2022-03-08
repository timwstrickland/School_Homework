package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class TrafficDisplay extends JPanel {

    private final List<TrafficLight> trafficLights;
    private final int trafficAreaWidth;
    private final int trafficAreaHeight;

    public TrafficDisplay(TrafficManager trafficManager) {
        super();
        trafficLights = trafficManager.getTrafficLights();
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
            trafficLights.forEach((trafficLight) -> {
                //draw(trafficLight, graphics, widthOffset, heightOffset);
                draw(trafficLight, graphics);
            });
        }
    }

    private void draw(TrafficLight trafficLight, Graphics graphics) {
        int diameter = trafficLight.getDiameter();
        graphics.setColor(trafficLight.getColor());
        graphics.drawOval((int) trafficLight.getX(), (int) trafficLight.getY(), diameter, diameter);
        graphics.fillOval((int) trafficLight.getX(), (int) trafficLight.getY(), diameter, diameter);




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
}
