package com.monocept.AbstractClass.Payment.model;

public class Walletpayment extends Payment {
	 // Constructor
    public Walletpayment(double amount) {
        super(amount);   // Call parent constructor
    }

    // Overriding abstract method
    @Override
    public void processPayment() {

        // Validate first
        if (!validateAmount()) {
            return;
        }

        double fee = amount * 0.01;   // 1% fee
        double totalAmount = amount + fee;

        System.out.println("Processing Wallet Payment...");
        System.out.println("Original Amount: " + amount);
        System.out.println("Processing Fee (1%): " + fee);
        System.out.println("Total Amount Paid: " + totalAmount);

        // Update amount so receipt shows final amount
        amount = totalAmount;
    }

}
