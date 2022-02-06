package com.company;
    /* File: TwoDimensionalShape.java
   Author: Timothy Strickland
   Date: 1/15/2022
   Purpose: Sub-class of Shape
   Used Dr. Vergamini's code as a starting point.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapesMenu {

        private abstract static class MenuEntry {
            private final String label;

            public MenuEntry(String label) {
                this.label = label;
            }

            public String getLabel() {
                return label;
            }

            abstract public Shape get(Scanner scanner);

            public String getStringAttribute(String attributeName, Scanner scanner) {
                // This method creates the strings presented to the user, modifying the object.
                System.out.print("What is the " + attributeName + " of the " + label.toLowerCase() + "? ");
                return scanner.nextLine();
            }

            public Double getDoubleAttribute(String attributeName, Scanner scanner) {
                // since all the main attributes are doubles for shapes, this will get the double attribute.
                double value = Double.parseDouble(getStringAttribute(attributeName, scanner));
                while (!(value >= 1)) {
                    System.out.println("Bad input, please input a number greater than 0");
                    value = Double.parseDouble(getStringAttribute(attributeName, scanner));
                }
                    return value;
                }
        }
        // Create entries for our menu, where we return the attribute name.
        private final static MenuEntry circleEntry = new MenuEntry("Circle") {

            @Override
            public Shape get(Scanner scanner) {
                return new Circle(getDoubleAttribute("radius", scanner));
            }
        };

        private final static MenuEntry rectangleEntry = new MenuEntry("Rectangle") {

            @Override
            public Shape get(Scanner scanner) {
                return new Rectangle(getDoubleAttribute("length", scanner), getDoubleAttribute("width", scanner));
            }

        };

        private final static MenuEntry squareEntry = new MenuEntry("Square") {

            @Override
            public Shape get(Scanner scanner) {
                return new Square(getDoubleAttribute("side", scanner));
            }
        };

        private final static MenuEntry triangleEntry = new MenuEntry("Triangle") {

            @Override
            public Shape get(Scanner scanner) {
                return new Triangle(getDoubleAttribute("height", scanner), getDoubleAttribute("base", scanner));
            }
        };

        private final static MenuEntry coneEntry = new MenuEntry("Cone") {

            @Override
            public Shape get(Scanner scanner) {
                return new Cone(getDoubleAttribute("radius", scanner), getDoubleAttribute("height", scanner));
            }
        };

        private final static MenuEntry cubeEntry = new MenuEntry("Cube") {

            @Override
            public Shape get(Scanner scanner) {
                return new Cube(getDoubleAttribute("edge", scanner));
            }
        };

        private final static MenuEntry cylinderEntry = new MenuEntry("Cylinder") {

            @Override
            public Shape get(Scanner scanner) {
                return new Cylinder(getDoubleAttribute("radius", scanner), getDoubleAttribute("height", scanner));
            }
        };

        private final static MenuEntry sphereEntry = new MenuEntry("Sphere") {

            @Override
            public Shape get(Scanner scanner) {
                return new Sphere(getDoubleAttribute("radius", scanner));
            }
        };

        private final static MenuEntry torusEntry = new MenuEntry("Torus") {

            @Override
            public Shape get(Scanner scanner) {
                return new Torus(getDoubleAttribute("majorRadius", scanner), getDoubleAttribute("minorRadius", scanner));
            }
        };

        public static void main(String[] args) {
            MenuEntry[] entries = new MenuEntry[] { circleEntry, rectangleEntry, squareEntry, triangleEntry, sphereEntry,
            cubeEntry, coneEntry, cylinderEntry, torusEntry};
            ArrayList<Shape> shapes = new ArrayList<>();
            Scanner inputScanner = new Scanner(System.in);
            try {
                while (true) {
                    int menuSelection = -1;
                    System.out.println("Select from the menu below:\n");
                    for (int entryIndex = 0; entryIndex < entries.length; ++entryIndex) {
                        // entries are counted from 1 for the user, but from 0 in the Java array
                        System.out.println((entryIndex + 1) + ". Construct a " + entries[entryIndex].getLabel());
                    }
                    System.out.println((entries.length + 1) + ". Build from the GUI");
                    System.out.println((entries.length + 2) + ". Exit the program ");
                    try {
                        menuSelection = Integer.parseInt(inputScanner.nextLine());
                    } catch (NumberFormatException numberFormatException) {
                        menuSelection = -1;
                    }
                    if (menuSelection >= 1 && menuSelection <= entries.length) {
                        // an actual valid shape selection has been made
                        final String label = entries[menuSelection - 1].getLabel();
                        System.out.println("You have selected a " + label);
                        try {
                            Shape Shape = entries[menuSelection - 1].get(inputScanner);
                            System.out.println(Shape);
                            shapes.add(Shape);
                        } catch (Exception badInput) {
                            System.out.println("Invalid input for " + label);
                        }
                    } else if (menuSelection > entries.length + 2) {
                        // no valid input
                        System.out.println("Bad input");
                    }
                    else if (menuSelection == entries.length + 1) {
                        System.out.println("GUI launched");
                        ShapesUI sg = new ShapesUI();
                        sg.setVisible(true);
                        sg.setAlwaysOnTop(true);
                    }
                    else {
                        // the last option was selected, this is the end of the interaction loop
                        break;
                    }
                    String continueInput = "";
                    while (true) {
                        System.out.println("Would you like to continue? (Y or N)");
                        continueInput = inputScanner.nextLine().toUpperCase();
                        if ("Y".equals(continueInput) || "N".equals(continueInput)) {
                            break;
                        }
                        System.out.println("Sorry I do not understand. Enter Y or N");
                    }
                    if ("N".equals(continueInput)) {
                        // end of the interaction loop not triggered by the main menu
                        break;
                    }
                }
            } finally {
                inputScanner.close();
            }
            System.out.println("***********");
            shapes.forEach(Shape -> {
                System.out.println(Shape);
            });
        }
}
