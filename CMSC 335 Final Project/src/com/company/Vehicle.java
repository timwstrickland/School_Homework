package com.company;

import java.awt.*;

public class Vehicle {
    private final int side;
    private float x;
    private final float y;
    private final float initialSpeed;
    private float currentSpeed;
    private final Color color;

    public Vehicle(int side, float x, float y, float initialSpeed) {
        this.side = side;
        this.x = x;
        this.y = y;
        this.initialSpeed = initialSpeed;
        currentSpeed = initialSpeed;
        color = Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public int getSide() {
        return side;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getInitialSpeed() {
        return initialSpeed;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(float currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void move(long deltaMilliseconds) {
        x += delta(currentSpeed, deltaMilliseconds);
    }

    static float delta(float deltaSpeed, long deltaMilliseconds) {
        return (deltaSpeed / 1000f) * deltaMilliseconds;
    }
}
