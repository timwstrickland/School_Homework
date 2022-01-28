package com.company;
/* File: Sphere.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Sphere extends ThreeDimensionalShape {

    public Sphere(double radius) {
        // Here we pass in the name to the super class.
        super("Sphere", (4/3) * (Math.PI * Math.pow(radius, 3)));
        // Since a Sphere is a type of ThreeDimensionalShape, we state that this class extends that class.
    }
}
