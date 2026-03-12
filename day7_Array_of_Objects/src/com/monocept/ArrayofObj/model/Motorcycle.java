package com.monocept.ArrayofObj.model;

public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double calculateToll() {
        return 50;  // fixed toll for motorcycle
    }
}