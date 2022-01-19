package com.company;
/* File: Sphere.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Sphere extends ThreeDimensionalShape {
    // Since a Sphere is a type of ThreeDimensionalShape, we state that this class extends that class.
    private final double radius;

    public Sphere(double radius) {
        // Here we pass in the name to the super class.
        super("Sphere");
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return (4/3) * (Math.PI * Math.pow(this.radius, 3));
    }
}
