package com.company;
/* File: Torus.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Torus extends ThreeDimensionalShape{
    // Since a Torus is a type of ThreeDimensionalShape, we state that this class extends that class.
    // A Torus needs a major radius and a minor radius.
    double majorRadius;
    double minorRadius;

    public Torus(String name, double volume, double majorRadius, double minorRadius) {
        super(name, volume);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double calculateVolume() {
        return (Math.PI * (this.minorRadius * this.minorRadius) * (2 * (Math.PI * this.majorRadius)));
    }
}
