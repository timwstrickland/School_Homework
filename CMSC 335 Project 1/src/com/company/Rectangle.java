package com.company;
/* File: Rectangle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Rectangle extends TwoDimensionalShape {

    public Rectangle(double length, double width) {
        // Here we pass in the name to the super class.
        super("Rectangle", length * width);
        // Since a Rectangle is a type of TwoDimensionalShape, we state that this class extends that class.
        // In order to calculate the area, we need to know the length and the width
    }
}
