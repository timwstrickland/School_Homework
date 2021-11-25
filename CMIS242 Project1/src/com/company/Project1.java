// This class file is part of the CMIS 242 Project 1 package.
package com.company;

import javax.swing.JFileChooser;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.System;

public class Project1 extends Component{

    public static void main(String[] args) throws FileNotFoundException {
        Project1 p = new Project1();
        Weight[] w = p.openFile();
        System.out.println(Arrays.toString(w));
        System.out.println(p.findMinimum(w, 25));
        System.out.println(p.findMaximum(w, 25));
        System.out.println(p.findAverage(w, 25));
    }
    Weight[] weight = new Weight[25];
    public Weight[] openFile() throws FileNotFoundException {
        int count = 0;
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            System.out.println("Selected File:" + selectedFile.getAbsolutePath());
            Scanner scanner = new Scanner(selectedFile.getAbsoluteFile());
            int pound;
            double ounce;
            while (scanner.hasNext()) {
                pound = scanner.nextInt();
                ounce = scanner.nextDouble();
                count++;
            }
            if (count > 25) {
                System.out.println("This file has more than 25 entries, " +
                        "please reduce the number of entries and try again");
                System.exit(1);
            }
            else {
                count = 0;
                Scanner s = new Scanner(selectedFile.getAbsoluteFile());
                while (s.hasNext()) {
                    pound = s.nextInt();
                    ounce = s.nextDouble();
                    weight[count] = new Weight(pound, ounce);
                    System.out.println(weight[count].toString());
                    count++;
                }
            }
        }
        return weight;
    }

    private Weight findMinimum(Weight[] weight, int arraySize) {
        Weight minimum = weight[0];
        for (int i = 0; i < arraySize; i++) {
            if (weight[i].lessThan(minimum)) {
                minimum = weight[i];
            }
        }
        System.out.println("The minimum weight is: ");
        return minimum;
    }

    private Weight findMaximum(Weight[] weight, int arraySize) {
        Weight maximum = weight[0];
        for (int i = 0; i < arraySize; i++) {
            if (!weight[i].lessThan(maximum)) {
                maximum = weight[i];
            }
        }
        System.out.println("The maximum weight is: ");
        return maximum;
    }

    private Weight findAverage(Weight[] weight, int arraySize) {
        Weight avgWeight = new Weight(0, 0);
        for (int i = 0; i < arraySize; i++) {
            avgWeight.addTo(weight[i]);
            System.out.println(avgWeight);
        }
        avgWeight.divide(arraySize);
        return avgWeight;
    }
}



