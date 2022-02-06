package com.company;

import javax.swing.*;
import java.awt.*;

/* File: Cone.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cone extends ThreeDimensionalShape {
    public Cone(double radius, double height) {
        // Here we pass in the name to the super class.
        super("Cone", (Math.PI * (radius * radius) * (height / 3)), new ImageIcon("Cone.png"));
        // Since a Cone is a type of ThreeDimensionalShape, we state that this class extends that class.
        // Cone needs radius and height
    }
}

