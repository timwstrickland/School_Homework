package com.company;

import javax.print.MultiDocPrintJob;

/* File: Torus.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Torus extends ThreeDimensionalShape{

    public Torus(double majorRadius, double minorRadius) {
        // Here we pass in the name to the super class.
        super("Torus", Math.PI * (minorRadius * minorRadius) * (2 * (Math.PI * majorRadius)));
        // Since a Torus is a type of ThreeDimensionalShape, we state that this class extends that class.
        // A Torus needs a major radius and a minor radius.
    }
}
