package com.monocept.BankApp.model;

public class SavingsAccount extends Account {

    private double minimumBalance;

    public SavingsAccount(int accNo, String name, double balance, double minBal) {

        super(accNo, name, balance);

        if(minBal < 0) {
            throw new IllegalArgumentException("Minimum balance cannot be negative");
        }

        this.minimumBalance = minBal;
    }

    @Override
    public void withdraw(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return;
        }

        if(balance - amount >= minimumBalance) {

            balance -= amount;
            System.out.println("Withdrawal successful");

        } else {

            System.out.println("Minimum balance must be maintained");
        }
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Minimum Balance: " + minimumBalance);
    }
}