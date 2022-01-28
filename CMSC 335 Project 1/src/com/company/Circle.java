package com.company;
/* File: Circle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Circle extends TwoDimensionalShape {

    public Circle(double radius) {
        // Here we pass in the name to the super class.
        super("Circle", Math.PI * (radius * radius));
        // Since a Circle is a type of TwoDimensionalShape, we state that this class extends that class.
        // In order to calculate the area of a circle, we need to know the radius of the circle.
    }
}
