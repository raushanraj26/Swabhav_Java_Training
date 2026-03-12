package com.monocept.AbstractClass.Payment.model;

public class UPIPayment extends Payment {

    // Constructor
    public UPIPayment(double amount) {
        super(amount);   // Call parent constructor
    }

    // Overriding abstract method
    @Override
    public void processPayment() {

        // Validate first
        if (!validateAmount()) {
            return;
        }

        System.out.println("Processing UPI Payment...");
        System.out.println("Amount Paid: " + amount);
        System.out.println("No Processing Fee for UPI.");

        // No fee added, so amount remains same
    }
}
