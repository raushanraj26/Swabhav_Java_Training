package com.monocept.VehicleRegistration.model;

public class Bike extends Vehicle {

    private boolean sportsBike;

    public Bike(String reg, String owner, double charge, boolean sportsBike) {
        super(reg, owner, charge);

        this.sportsBike = sportsBike;
    }

    @Override
    public double calculateUsageCharge() {

        if(sportsBike)
            return baseCharge + 200;
        else
            return baseCharge + 100;
    }

    @Override
    public void displayDetails() {

        System.out.println("\n--- Bike Details ---");

        super.displayCommonDetails();

        System.out.println("Sports Bike: " + sportsBike);

        System.out.println("Total Usage Charge: " + calculateUsageCharge());
    }
}