package com.company;

/* File: TwoDimensionalShape.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of Shape
 */
public abstract class TwoDimensionalShape extends Shape {
    // Since a TwoDimensionalShape is a type of shape, we state that this class extends shape.
    // This is an abstract class, since there is no need to make a TwoDimensionalShape by itself.
    // We want more restricted access to our area variable by giving no access modifier.
    double area;


    public TwoDimensionalShape(String name) {
        // Here we pass the number of dimensions to the superclass, the name is set in the subclass
        // since we don't know what type of shape this will be yet.
        super(name, 2);
    }

    @Override
    public String getDescriptive() {
        this.area=calculateArea();
        return "Area = " + area;
    }

    public abstract double calculateArea();
}
