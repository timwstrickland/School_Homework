package com.company;

import java.awt.*;

/* File: Rectangle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Rectangle extends TwoDimensionalShape {
    private final double length;
    private final double width;


    public Rectangle(double length, double width) {
        super("Rectangle", length * width);
        this.length = length;
        this.width = width;
        // Since a Rectangle is a type of TwoDimensionalShape, we state that this class extends that class.
        // In order to calculate the area, we need to know the length and the width
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(0,0, (int)this.length, (int)this.width);
    }
}
