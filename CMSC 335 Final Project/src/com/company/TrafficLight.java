package com.company;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class TrafficLight {
    private final int radius; // pixels
    private final float x;
    private final float y;
    private Color color;
    private double timeRemaining;
    private final double lightTimer;

    public TrafficLight(int radius, float x, float y, double lightTimer) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        color = pickColor();
        this.lightTimer = lightTimer;
        timeRemaining = lightTimer;
    }

    public void updateColor() {
        if(timeRemaining <= 0) {
            color = switchColor();
            timeRemaining = lightTimer;
        }
    }

    private Color pickColor() {
        return switch (ThreadLocalRandom.current().nextInt(2)) {
            case 0 -> Color.GREEN;
            case 1 -> Color.RED;
            default -> Color.BLACK;
        };
    }

    private Color switchColor() {
        if (color.equals(Color.RED)) {
            return Color.GREEN;
        }
        return Color.RED;
    }

    public double getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(float timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public Color getColor() {
        return color;
    }

    public int getDiameter() {
        return 2 * radius;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
