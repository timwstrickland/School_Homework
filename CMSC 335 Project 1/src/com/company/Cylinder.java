package com.company;
/* File: Cylinder.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cylinder extends ThreeDimensionalShape {

    public Cylinder(double radius, double height) {
        // Here we pass in the name to the super class.
        super("Cylinder", Math.PI * ((radius * radius) * height));
        // Since a Cylinder is a type of ThreeDimensionalShape, we state that this class extends that class.
        // For cylinder we need radius and height.
    }
}
