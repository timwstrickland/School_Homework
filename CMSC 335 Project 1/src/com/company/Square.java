package com.company;
/* File: Square.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Square extends TwoDimensionalShape{
    // Since a Square is a type of TwoDimensionalShape, we state that this class extends that class.
    // We just need to know 1 side of a square, since all sides is of equal length.
    double side;
    public Square(String name, double area, double side) {
        super(name, area);
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return this.side * this.side;
    }
}
