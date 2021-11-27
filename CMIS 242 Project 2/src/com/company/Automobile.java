package com.company;

public class Automobile {
    private String makeModel;
    private int price;

    public Automobile() {
        this.makeModel = "Ford Mustang";
        this.price = 30000;
    }
    public Automobile(String makeModel, int price) {
        this.makeModel = makeModel;
        this.price = price;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public int getPrice() {
        return price;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double salesTax(int price) {
        return price * .05;
    }

    public String toString() {
        return ("automobile make: " + this.makeModel
        + "\nprice: " + this.price + "\nsales tax: " + salesTax(this.price));
    }
}
