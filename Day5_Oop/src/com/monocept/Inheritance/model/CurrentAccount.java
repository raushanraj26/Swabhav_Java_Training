package com.monocept.Inheritance.model;

public class CurrentAccount extends BankAccountSystem {

    private double overdraftLimit;

    public CurrentAccount(int accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {

        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
        displayDetails();
    }
}
