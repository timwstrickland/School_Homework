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

    public Rectangle(String name, double area, double length, double width) {
        super(name, area);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
