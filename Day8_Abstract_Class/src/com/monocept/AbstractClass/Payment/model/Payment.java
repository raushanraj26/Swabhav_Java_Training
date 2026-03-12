package com.monocept.AbstractClass.Payment.model;

public abstract class Payment {

	protected double amount;
    protected boolean isValid;   // Track validity

    // Constructor
    public Payment(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount! Must be greater than 0.");
            this.isValid = false;
            this.amount = 0;
        } else {
            this.amount = amount;
            this.isValid = true;
        }
    }

    public boolean validateAmount() {
        return isValid;
    }

    public abstract void processPayment();

    public void generateReceipt() {

        if (!isValid) {
            System.out.println("Cannot generate receipt. Invalid payment.");
            return;
        }

        System.out.println("----- Payment Receipt -----");
        System.out.println("Amount Paid: " + amount);
        System.out.println("Payment Successful!");
        System.out.println("---------------------------");
    }
}
