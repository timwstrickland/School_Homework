package com.company;

public class Hybrid extends Automobile {
    private int milesPerGallon;

    public Hybrid() {
        super.setMake("Tesla");
        super.setModel("Model S");
        super.setPrice(50000);
        this.milesPerGallon = 35;
    }

    public Hybrid (String make, String model, int price, int milesPerGallon) {
        super.setMake(make);
        super.setModel(model);
        super.setPrice(price);
        this.milesPerGallon = milesPerGallon;
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    @Override
    public double salesTax(int price) {
        int discount;
        if (milesPerGallon <= 40) {
            discount = 100;
        }
        else {
            discount = (milesPerGallon - 40) * 2;
        }
        return super.salesTax(price) - discount;
    }

    @Override
    public String toString() {
        return ("automobile make: " + super.getMake() + "\nautomobile model: " + super.getModel()
                + "\nprice: " + super.getPrice() + " \nsales tax: " + salesTax(super.getPrice())
                + "\nMiles per Gallon: " + this.milesPerGallon);
    }
}
