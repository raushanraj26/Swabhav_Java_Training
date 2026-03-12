package com.monocept.Inheritance.model;

public class BankAccountSystem {
	  protected int accountNumber;
	    protected String holderName;
	    protected double balance;

	    // Constructor
	    public BankAccountSystem(int accountNumber, String holderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.holderName = holderName;
	        this.balance = balance;
	    }

	    // Deposit
	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println("Amount Deposited: " + amount);
	        displayDetails();
	    }

	    // Basic Withdraw
	    public void withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Amount Withdrawn: " + amount);
	        } else {
	            System.out.println("Insufficient Balance!");
	        }
	        displayDetails();
	    }

	    public void displayDetails() {
	        System.out.println("Account No: " + accountNumber);
	        System.out.println("Holder Name: " + holderName);
	        System.out.println("Balance: " + balance);
	        System.out.println("--------------------------");
	    }

}


 
 



