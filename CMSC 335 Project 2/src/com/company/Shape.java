package com.company;

import java.util.Scanner;

/* File: Shape.java
   Author: Timothy Strickland
   Date: 1/9/2022
   Purpose: Super class that creates name and number of dimensions
 */
public abstract class Shape {
    // since all classes are an object, there is no reason to state that Shape extends Object.
    // All shapes will need to have a name, all shapes will need to have a number of dimensions. Therefore these make
    // sense to be in the super class.
    protected final String name;
    protected final int numberOfDimensions;

    public Shape(String name, int numberOfDimensions) {
        super();
        this.name = name;
        this.numberOfDimensions = numberOfDimensions;
    }

    @Override
    public String toString() {
        return String.format("%s: %s with %d dimensions", name, getDescriptive(), numberOfDimensions);
    }

    public abstract String getDescriptive();
}
