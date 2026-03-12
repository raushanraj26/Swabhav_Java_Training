package com.monocept.ArrayofObj.model;

public abstract class Vehicle {

    protected String vehicleNumber;

    
    private static int totalVehiclesProcessed = 0;
    private static double totalTollCollected = 0;

    // Constructor
    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        totalVehiclesProcessed++;
    }

    
    public abstract double calculateToll();

  
    // Update total toll
    public static void addToll(double amount) {
        totalTollCollected += amount;
    }

    public static int getTotalVehiclesProcessed() {
        return totalVehiclesProcessed;
    }

    public static double getTotalTollCollected() {
        return totalTollCollected;
    }

    public void display() {
        System.out.println("Vehicle Number: " + vehicleNumber);
    }
}