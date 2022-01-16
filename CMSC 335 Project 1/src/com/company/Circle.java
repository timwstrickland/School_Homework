package com.company;
/* File: Circle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Circle extends TwoDimensionalShape {
    // Since a Circle is a type of TwoDimensionalShape, we state that this class extends that class.
    // In order to calculate the area of a circle, we need to know the radius of the circle.
    double radius;

    public Circle(String name, double area, double radius) {
        super(name, area);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (this.radius * 2);
    }
}
