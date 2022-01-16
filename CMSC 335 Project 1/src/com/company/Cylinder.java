package com.company;
/* File: Cylinder.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cylinder extends ThreeDimensionalShape {
    // Since a Cylinder is a type of ThreeDimensionalShape, we state that this class extends that class.
    // For cylinder we need radius and height.
    double radius;
    double height;

    public Cylinder(String name, double volume, double radius, double height) {
        super(name, volume);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return Math.PI * ((this.radius * this.radius) * height);
    }
}
