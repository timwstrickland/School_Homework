package com.company;
/* File: Triangle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Triangle extends TwoDimensionalShape {
    // Since a Triangle is a type of TwoDimensionalShape, we state that this class extends that class.
    // In order to calculate the area of a triangle, we need to know the base and the height.
    double height;
    double base;

    public Triangle(String name, double area, double height, double base) {
        super(name, area);
        this.height = height;
        this.base = base;
    }

    @Override
    public double calculateArea() {
        return (height * base)/2;
    }
}
