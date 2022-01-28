package com.company;
/* File: Triangle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Triangle extends TwoDimensionalShape {

    public Triangle(double height, double base) {
        super("Triangle", (height * base)/2);
        // Since a Triangle is a type of TwoDimensionalShape, we state that this class extends that class.
        // In order to calculate the area of a triangle, we need to know the base and the height.
    }
}
