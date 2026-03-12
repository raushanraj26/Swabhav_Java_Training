package com.monocept.Encapsulation.model;

public class BankAccount {
	private final String accountNumber;
    private String accountHolderName;
    private double balance;

    private static int counter = 1000;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = "ACCOUNT" + (++counter);
        this.accountHolderName = accountHolderName;

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Set to 0.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    private void calculateInterest() {
        double interest = balance * 0.05;
        balance += interest;
    }

    private boolean interestApplied = false;

    public void applyAnnualInterest() {
        if (interestApplied) {
            System.out.println("Interest already applied this year.");
            return;
        }

        calculateInterest();
        System.out.println("Interest applied.");
        interestApplied = true;
    }

}
