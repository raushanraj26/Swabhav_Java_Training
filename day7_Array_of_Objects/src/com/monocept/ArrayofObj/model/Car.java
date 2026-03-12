package com.monocept.ArrayofObj.model;

public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber); // constructor chaining
    }

    @Override
    public double calculateToll() {
        return 100;  // fixed toll for car
    }
}
