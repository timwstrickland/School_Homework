package com.company;

import javax.swing.*;
import java.awt.*;

/* File: Triangle.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of TwoDimensionalShape
 */
public class Triangle extends TwoDimensionalShape {
    private final ImageIcon shapeImage;

    public Triangle(double height, double base) {
        super("Triangle", (height * base)/2);
        shapeImage = new ImageIcon("Triangle.png");
        // Since a Triangle is a type of TwoDimensionalShape, we state that this class extends that class.
        // In order to calculate the area of a triangle, we need to know the base and the height.
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(shapeImage.getImage(), 0, 0, null);
    }
}
