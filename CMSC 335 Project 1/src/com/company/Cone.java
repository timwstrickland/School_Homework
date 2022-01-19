package com.company;
/* File: Cone.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cone extends ThreeDimensionalShape{
    // Since a Cone is a type of ThreeDimensionalShape, we state that this class extends that class.
    // Cone needs radius and height
    double radius;
    double height;

    public Cone(double radius, double height) {
        super ("Cone");
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return (Math.PI * (this.radius * this.radius) * (height/3));
    }
}
