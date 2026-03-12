package com.monocept.VehicleRegistration.model;

public abstract class Vehicle {

    private String registrationNumber;
    private String ownerName;
    protected double baseCharge;

    public Vehicle(String registrationNumber, String ownerName, double baseCharge) {

        if(registrationNumber == null || registrationNumber.trim().isEmpty())
            throw new IllegalArgumentException("Invalid Registration Number");

        if(ownerName == null || ownerName.trim().isEmpty())
            throw new IllegalArgumentException("Invalid Owner Name");

        if(baseCharge < 0)
            throw new IllegalArgumentException("Invalid Charge");

        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.baseCharge = baseCharge;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBaseCharge() {
        return baseCharge;
    }

    public void displayCommonDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Base Charge: " + baseCharge);
    }

    public abstract double calculateUsageCharge();

    public abstract void displayDetails();
}