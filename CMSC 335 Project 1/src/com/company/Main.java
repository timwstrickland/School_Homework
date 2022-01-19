package com.company;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getChoice(getUserInput());
    }

    public static void printMenu() {
        //  Prints out the menu for the benefit of the user.
        System.out.println("*********Welcome to the Java OO Shapes Program*********");
        System.out.println("Select from the menu below:\n");
        System.out.println("1. Construct a Circle");
        System.out.println("2. Construct a Rectangle");
        System.out.println("3. Construct a Square");
        System.out.println("4. Construct a Triangle");
        System.out.println("5. Construct a Sphere");
        System.out.println("6. Construct a Cube");
        System.out.println("7. Construct a Cone");
        System.out.println("8. Construct a Cylinder");
        System.out.println("9. Construct a Torus");
        System.out.println("10. Exit the Program");
    }
    public static int getUserInput() {
        // method that grabs the input from the user.
        int userInput;
        printMenu();
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                userInput = input.nextInt();
                if (userInput > 10 || userInput < 0) {
                    throw new ArithmeticException("Please enter an integer between 1 and 10");
                } else {
                    return userInput;
                }
            } catch (Exception e) {
                System.out.println("The input was invalid, please enter an INTEGER between 1 and 10");
            }
        }
    }

    public static void getChoice(int choice) {
        Scanner scan = new Scanner(System.in);
            try {
                    switch (choice) {
                        case 1:
                            System.out.println("You have selected a Circle");
                            System.out.println("What is the radius?");
                            double radius = scan.nextDouble();
                            Circle circle = new Circle(radius);
                            circle.calculateArea();
                            System.out.println(circle.toString());
                            break;
                        case 2:
                            System.out.println("You have selected a Rectangle");
                            System.out.println("What is the length?");
                            double length = scan.nextDouble();
                            System.out.println("What is the width?");
                            double width = scan.nextDouble();
                            Rectangle rectangle = new Rectangle(length, width);


                    }

                }
        catch (Exception e) {
            System.out.println("That is not a valid choice, please try again");
        }
    }
}
