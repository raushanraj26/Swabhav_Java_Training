package com.monocept.MultipleException.model;

public class BankService {
	public static double withdraw(double balance, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        return balance - amount;
    }

}
