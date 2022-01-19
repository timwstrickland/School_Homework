package com.company;
/* File: Cylinder.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cylinder extends ThreeDimensionalShape {
    // Since a Cylinder is a type of ThreeDimensionalShape, we state that this class extends that class.
    // For cylinder we need radius and height.
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        // Here we pass in the name to the super class.
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return Math.PI * ((this.radius * this.radius) * height);
    }
}
