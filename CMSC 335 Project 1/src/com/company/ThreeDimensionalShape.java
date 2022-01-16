package com.company;

/* File: ThreeDimensionalShape.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of Shape
 */
public abstract class ThreeDimensionalShape extends Shape {
    // Since a ThreeDimensionalShape is a type of shape, we state that this class extends shape.
    // Three dimensional shapes use volume instead of area.
    double volume;

    public ThreeDimensionalShape(String name, double volume) {
        super(name, 3);
        this.volume = volume;
    }

    public abstract double calculateVolume();
}
