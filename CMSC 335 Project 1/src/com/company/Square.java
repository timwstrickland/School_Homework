package com.company;
/* File: Square.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Square extends TwoDimensionalShape{
    // Since a Square is a type of TwoDimensionalShape, we state that this class extends that class.
    // We just need to know 1 side of a square, since all sides are of equal length.
    double side;

    public Square(double side) {
        // Constructor that sets the name and side of the Square.
        super("Square");
        this.side = side;
    }

    @Override
    public double calculateArea() {
        // This method calculates the area of the square and sets the area in the TwoDimensionalShape to be referenced.
        this.area =  this.side * this.side;
        return this.area;
    }
}
