package com.company;

import javax.swing.*;
import java.awt.*;

/* File: Cube.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of ThreeDimensionalShape
 */
public class Cube extends ThreeDimensionalShape {

    public Cube(double edge) {
        // Here we pass in the name to the super class.
        super("Cube", Math.pow(edge, 3), new ImageIcon("Cube.png"));
        // Since a Cube is a type of ThreeDimensionalShape, we state that this class extends that class.
        // A cube needs an edge.
    }
}
