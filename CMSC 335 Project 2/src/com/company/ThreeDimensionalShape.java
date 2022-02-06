package com.company;

import javax.swing.*;
import java.awt.*;

/* File: ThreeDimensionalShape.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of Shape
 */
public abstract class ThreeDimensionalShape extends Shape {
    private final ImageIcon shapeImage;
    // Since a ThreeDimensionalShape is a type of shape, we state that this class extends shape.
    // Three dimensional shapes use volume instead of area.
    // This is an abstract class, since there is no need to make a ThreeDimensionalShape by itself.
    // We want more restricted access to our area variable by giving no access modifier.
    final double volume;

    public ThreeDimensionalShape(String name, double volume, ImageIcon shapeImage) {
        // Here we pass the number of dimensions to the superclass, the name is set in the subclass
        // since we don't know what type of shape this will be yet.
        super(name, 3);
        this.shapeImage = shapeImage;
        this.volume = volume;
    }

    @Override
    public String getDescriptive() {
        return "Volume = " + volume;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(shapeImage.getImage(), 0, 0, null);
    }
}