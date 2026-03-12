package com.monocept.BankApp.model;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accNo, String name, double balance, double overdraft) {

        super(accNo, name, balance);

        if(overdraft < 0) {
            throw new IllegalArgumentException("Overdraft cannot be negative");
        }

        this.overdraftLimit = overdraft;
    }

    @Override
    public void withdraw(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return;
        }

        if(balance + overdraftLimit >= amount) {

            balance -= amount;
            System.out.println("Withdrawal successful");

        } else {

            System.out.println("Overdraft limit exceeded");
        }
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Account Type: Current");
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}