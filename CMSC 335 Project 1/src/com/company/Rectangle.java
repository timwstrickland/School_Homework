package com.company;
/* File: Rectangle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Rectangle extends TwoDimensionalShape {
    // Since a Rectangle is a type of TwoDimensionalShape, we state that this class extends that class.
    // In order to calculate the area, we need to know the length and the width
    double length;
    double width;

    public Rectangle(double length, double width) {
        // Constructor that sets the name, length and width of the Rectangle.
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
