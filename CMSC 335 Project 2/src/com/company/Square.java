package com.company;

import java.awt.*;

/* File: Square.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Square extends TwoDimensionalShape{
    private final double side;

    public Square(double side) {
        // Constructor that sets the name and side of the Square.
        super("Square", side*side);
        this.side = side;
        // Since a Square is a type of TwoDimensionalShape, we state that this class extends that class.
        // We just need to know 1 side of a square, since all sides are of equal length.
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(0,0, (int)this.side, (int)this.side);
    }
}
