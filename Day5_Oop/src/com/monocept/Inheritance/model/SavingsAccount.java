package com.monocept.Inheritance.model;

public class SavingsAccount extends BankAccountSystem {

    private double minBalance;

    public SavingsAccount(int accountNumber, String holderName, double balance, double minBalance) {
        super(accountNumber, holderName, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount) {

        if (balance - amount >= minBalance) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw! Minimum balance must be maintained.");
            displayDetails();
        }
    }
}

