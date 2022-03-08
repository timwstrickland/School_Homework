package com.company;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Vehicle {
    private final int radius; // pixels
    private float x;
    private float y;
    private float speedX; // pixels per second
    private float speedY;
    private Color color;
    private float spokeAngle = 0;

    public Vehicle(int radius, float x, float y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        color = pickColor();
    }

    public void updateColorAndSpokeAngle() {
        if (ThreadLocalRandom.current().nextFloat() > .999) { // picks a color .1% of the time
            color = pickColor();
        }
        spokeAngle += .001;
        if (spokeAngle > Math.PI * 2) {
            spokeAngle = 0;
        }
    }

    public float getSpokeAngle() {
        return spokeAngle;
    }

    private Color pickColor() {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.RED;
            case 2:
                return Color.YELLOW;
            default:
                return Color.BLACK;
        }
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

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void move(long deltaMilliseconds) {
        x += delta(speedX, deltaMilliseconds);
        y += delta(speedY, deltaMilliseconds);
    }

    public void bounce() {
        speedX *= -1;
        speedY *= -1;
    }

    static float delta(float deltaSpeed, long deltaMilliseconds) {
        return (deltaSpeed / 1000f) * deltaMilliseconds;
    }

    public float getDistance(Vehicle otherBubble) {
        float deltaX = x - otherBubble.x;
        float deltaY = y - otherBubble.y;
        double centerDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return (float) (centerDistance - radius - otherBubble.radius);
    }
}
