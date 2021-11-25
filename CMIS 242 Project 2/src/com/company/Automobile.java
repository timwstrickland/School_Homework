package com.company;

public class Automobile {
    private String make;
    private String model;
    private int price;

    public Automobile() {
        this.make = "Ford";
        this.model = "Mustang";
        this.price = 30000;
    }
    public Automobile(String make, String model, int price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double salesTax(int price) {
        return price * .05;
    }

    public String toString() {
        return ("automobile make: " + this.make + "\nautomobile model: " + this.model
        + "\nprice: " + this.price + "\nsales tax: " + salesTax(this.price));
    }
}
