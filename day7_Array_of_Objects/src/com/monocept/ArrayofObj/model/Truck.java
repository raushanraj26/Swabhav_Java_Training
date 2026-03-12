package com.monocept.ArrayofObj.model;

public class Truck extends Vehicle {

    private double weight;

    public Truck(String vehicleNumber, double weight) {
        super(vehicleNumber);
        this.weight = weight;
    }

    @Override
    public double calculateToll() {
        return 200 + (weight * 10);  // base + weight charge
    }
}