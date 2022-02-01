package com.company;
/* File: Cube.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cube extends ThreeDimensionalShape {

    public Cube(double edge) {
        // Here we pass in the name to the super class.
        super("Cube", Math.pow(edge, 3));
        // Since a Cube is a type of ThreeDimensionalShape, we state that this class extends that class.
        // A cube needs an edge.
    }
}
