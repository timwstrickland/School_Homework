package com.company;

public class Electric extends Automobile {
    private int weight;

    public Electric(String make, String model, int price, int weight) {
        this.weight = weight;
        super.setMake(make);
        super.setModel(model);
        super.setPrice(price);
    }

    public void setWeight (int weight) {
        this.weight = weight;
    }

    public int getWeight () {
        return weight;
    }
    @Override
    public double salesTax(int price) {
        int discount;
        if (this.weight < 3000) {
            discount = 200;
        }
        else {
            discount = 150;
        }
        return super.salesTax(price) - discount;
    }

    @Override
    public String toString() {
        return ("automobile make: " + super.getMake() + "\nautomobile model: " + super.getModel()
                + "\nprice: " + super.getPrice() + " \nsales tax: " + salesTax(super.getPrice())
                + "\nWeight: " + this.weight);
    }
}
