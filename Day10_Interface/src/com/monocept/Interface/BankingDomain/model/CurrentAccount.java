package com.monocept.Interface.BankingDomain.model;

public class CurrentAccount implements AccountOperation {

    private double balance;
    private final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
    	if(amount<=0) {
     	   System.out.println("Amount must be greater than 0.");
     	   return;
     	   
        }
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) {
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}