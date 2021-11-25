// This class file is part of the CMIS 242 Project 1 package.
package com.company;

public class Weight {
    //Initialize variables for the weight class
    private double pounds;
    private double ounces;
    private final double poundsToOunces = 16;

    public Weight(double pounds, double ounces) {
        this.pounds = pounds;
        this.ounces = ounces;
    }

    public boolean lessThan (Weight w) {
        return w.toOunces() > toOunces();
    }

    public void addTo(Weight w) {
        //Adds ounces to the new weight and re-calculates
        this.ounces = this.ounces + w.toOunces();
        normalize();
    }

    public void divide(int divisor) {
        //Divides ounces by the number of the amount passed in.
        if (divisor != 0) {
            this.ounces = toOunces() / divisor;
            normalize();
        }
    }

    public String toString() {
        return String.format("%.3f", this.pounds) + "lbs " + String.format("%.3f", this.ounces) + " ounces";
    }

    private double toOunces() {
        //converts pounds to ounces so that math can be done on the basic term.
        return this.pounds * poundsToOunces + this.ounces;
    }

    private void normalize() {
        //re-calculates the weight so that it is displayed in pounds and ounces.
        while (this.ounces > poundsToOunces) {
            ++this.pounds;
            this.ounces = this.ounces - poundsToOunces;
        }
    }
}

