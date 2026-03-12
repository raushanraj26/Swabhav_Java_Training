package com.monocept.constructor.model;

public class PremiumAccount extends BankAccount {

    private static final double BONUS_AMOUNT = 1000.0;

    // Constructor with default balance
    public PremiumAccount(String accountNumber, String accountHolderName) {
        super(accountNumber, accountHolderName);
        this.balance += BONUS_AMOUNT;
    }

    // Constructor with initial balance
    public PremiumAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
        this.balance += BONUS_AMOUNT;
    }

    @Override
    public void displayAccount() {
        super.displayAccount();
        System.out.println("Bonus Added: ₹" + BONUS_AMOUNT);
    }
}