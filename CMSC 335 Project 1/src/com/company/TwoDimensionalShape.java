package com.company;

/* File: TwoDimensionalShape.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of Shape
 */
public abstract class TwoDimensionalShape extends Shape {
    // Since a TwoDimensionalShape is a type of shape, we state that this class extends shape.
    double area;


    public TwoDimensionalShape(String name, double area) {
        // Constructor that calls the super constructor.
        super(name, 2);
        this.area = area;
    }

    public abstract double calculateArea();
}
