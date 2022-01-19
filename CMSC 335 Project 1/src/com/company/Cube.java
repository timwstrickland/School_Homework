package com.company;
/* File: Cube.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cube extends ThreeDimensionalShape{
    // Since a Cube is a type of ThreeDimensionalShape, we state that this class extends that class.
    // A cube needs an edge.
    double edge;

    public Cube(double edge) {
        super("Cube");
        this.edge = edge;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(this.edge, 3);
    }
}
