package com.company;
/* File: Rectangle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Rectangle extends TwoDimensionalShape {
    // Since a Rectangle is a type of TwoDimensionalShape, we state that this class extends that class.
    // In order to calculate the area, we need to know the length and the width
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        // Here we pass in the name to the super class.
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        // This method calculates the area of the rectangle and sets the area in the TwoDimensionalShape to be referenced.
        this.area = length * width;
        return this.area;
    }
}
