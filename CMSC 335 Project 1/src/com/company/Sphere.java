package com.company;
/* File: Sphere.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Sphere extends ThreeDimensionalShape {
    // Since a Sphere is a type of ThreeDimensionalShape, we state that this class extends that class.
    double radius;

    public Sphere(String name, double volume, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return (4/3) * (Math.PI * Math.pow(this.radius, 3));
    }
}
