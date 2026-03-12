package com.monocept.VehicleRegistration.model;

public class Car extends Vehicle {

    private int numberOfSeats;

    public Car(String reg, String owner, double charge, int seats) {
        super(reg, owner, charge);

        if(seats <= 0)
            throw new IllegalArgumentException("Invalid seat number");

        this.numberOfSeats = seats;
    }

    @Override
    public double calculateUsageCharge() {
        return baseCharge + (numberOfSeats * 50);
    }

    @Override
    public void displayDetails() {

        System.out.println("\n--- Car Details ---");

        super.displayCommonDetails();

        System.out.println("Number of Seats: " + numberOfSeats);

        System.out.println("Total Usage Charge: " + calculateUsageCharge());
    }
}