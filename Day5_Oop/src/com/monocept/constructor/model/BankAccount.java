package com.monocept.constructor.model;

public class BankAccount {

    // Static interest rate (same for all accounts)
    private static final double INTEREST_RATE;

    static {
        INTEREST_RATE = 5.0;   // initialized once
    }

    // Fields
    private final String accountNumber;   // immutable
    private String accountHolderName;
    protected double balance;

    // Constructor with default balance (₹0)
    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0); // constructor chaining
    }

    // Constructor with balance
    public BankAccount(String accountNumber, String accountHolderName, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        if (balance < 0) {
            System.out.println("Balance cannot be negative. Setting balance to ₹0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return INTEREST_RATE;
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Interest Rate: " + INTEREST_RATE + "%");
    }
}