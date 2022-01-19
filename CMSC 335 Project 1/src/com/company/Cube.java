package com.company;
/* File: Cube.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cube extends ThreeDimensionalShape{
    // Since a Cube is a type of ThreeDimensionalShape, we state that this class extends that class.
    // A cube needs an edge.
    private final double edge;

    public Cube(double edge) {
        // Here we pass in the name to the super class.
        super("Cube");
        this.edge = edge;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(this.edge, 3);
    }
}
