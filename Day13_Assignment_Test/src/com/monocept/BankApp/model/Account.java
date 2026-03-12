package com.monocept.BankApp.model;

public abstract class Account {

    private int accountNumber;
    private String holderName;
    protected double balance;

    public Account(int accountNumber, String holderName, double balance) {

        if(balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {

        if(amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }

        balance += amount;
    }

    public abstract void withdraw(double amount);

    public void displayDetails() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}