package com.company;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class TrafficLight {
    private final int radius; // pixels
    private float x;
    private float y;
    private Color color;
    private float timeRemaining;

    public TrafficLight(int radius, float x, float y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        color = pickColor();
    }

    public void updateColor() {
        color = switchColor();
    }

    private Color pickColor() {
        switch (ThreadLocalRandom.current().nextInt(2)) {
            case 0:
                return Color.GREEN;
            case 1:
                return Color.RED;
            default:
                return Color.BLACK;
        }
    }

    private Color switchColor() {
        if (color.equals(Color.RED)) {
            return Color.GREEN;
        }
        return Color.RED;
    }

    public Color getColor() {
        return color;
    }

    public int getDiameter() {
        return 2 * radius;
    }

    public float getLeftX() {
        return x - radius;
    }

    public float getTopY() {
        return y - radius;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

//    public void move(long deltaMilliseconds) {
//        x += delta(speedX, deltaMilliseconds);
//        y += delta(speedY, deltaMilliseconds);
//    }
//
//    public void bounce() {
//        speedX *= -1;
//        speedY *= -1;
//    }
//
//    static float delta(float deltaSpeed, long deltaMilliseconds) {
//        return (deltaSpeed / 1000f) * deltaMilliseconds;
//    }

    public float getDistance(TrafficLight otherLight) {
        // double centerDistance = Math.sqrt(deltaX * deltaX);
        return x - otherLight.x;
    }
}