package com.monocept.AbstractClass.Payment.model;

public class CreditCardPayment extends Payment {

    // Constructor
    public CreditCardPayment(double amount) {
        super(amount);   // Call parent constructor
    }

    // Overriding abstract method
    @Override
    public void processPayment() {

        // Validate first
        if (!validateAmount()) {
            return;
        }

        double fee = amount * 0.02;     // 2% fee
        double totalAmount = amount + fee;

        System.out.println("Processing Credit Card Payment...");
        System.out.println("Original Amount: " + amount);
        System.out.println("Processing Fee (2%): " + fee);
        System.out.println("Total Amount Paid: " + totalAmount);

        // Update amount so receipt shows final amount
        amount = totalAmount;
    }
}
