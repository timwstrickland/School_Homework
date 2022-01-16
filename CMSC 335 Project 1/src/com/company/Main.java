package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getUserInput();
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
}
