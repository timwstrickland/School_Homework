package com.company;

import java.awt.*;

public class Vehicle {
    private final int side; // pixels
    private float x;
    private float y;
    private final float intialSpeed; // pixels per second
    private float currentSpeed;
    //private float speedY;
    private final Color color;
    //private float spokeAngle = 0;

    public Vehicle(int side, float x, float y, float intialSpeed) {
        this.side = side;
        this.x = x;
        this.y = y;
        this.intialSpeed = intialSpeed;
        currentSpeed = intialSpeed;
        color = Color.BLACK;
    }

//    public void updateColorAndSpokeAngle() {
//        if (ThreadLocalRandom.current().nextFloat() > .999) { // picks a color .1% of the time
//            color = pickColor();
//        }
//        spokeAngle += .001;
//        if (spokeAngle > Math.PI * 2) {
//            spokeAngle = 0;
//        }
//    }

//    public float getSpokeAngle() {
//        return spokeAngle;
//    }

//    private Color pickColor() {
//        switch (ThreadLocalRandom.current().nextInt(3)) {
//            case 0:
//                return Color.BLUE;
//            case 1:
//                return Color.RED;
//            case 2:
//                return Color.YELLOW;
//            default:
//                return Color.BLACK;
//        }
//    }
//    private void setColor(Color color) {
//        this.color = color;
//    }

    public Color getColor() {
        return color;
    }

    public int getSide() {
        return side;
    }
//
//    public float getLeftX() {
//        return x - radius;
//    }
//
//    public float getTopY() {
//        return y - radius;
//    }

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

//    public int getRadius() {
//        return radius;
//    }

    public float getIntialSpeed() {
        return intialSpeed;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(float currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

//    public float getSpeedY() {
//        return speedY;
//    }

//    public void setSpeedY(float speedY) {
//        this.speedY = speedY;
//    }

    public void move(long deltaMilliseconds) {
        x += delta(currentSpeed, deltaMilliseconds);
        //y += delta(speedY, deltaMilliseconds);
    }

//    public void bounce() {
//        speedX *= -1;
//        speedY *= -1;
//    }

    static float delta(float deltaSpeed, long deltaMilliseconds) {
        return (deltaSpeed / 1000f) * deltaMilliseconds;
    }

//    public float getDistance(Vehicle otherBubble) {
//        float deltaX = x - otherBubble.x;
//        float deltaY = y - otherBubble.y;
//        double centerDistance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
//        //return (float) (centerDistance - radius - otherBubble.radius);
//        return (float)centerDistance;
//    }
}
