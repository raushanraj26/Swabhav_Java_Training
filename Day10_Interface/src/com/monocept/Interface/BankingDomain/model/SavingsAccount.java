package com.monocept.Interface.BankingDomain.model;

public class SavingsAccount implements AccountOperation {
	private double balance;
    private int withdrawalCount = 0;
    private final int MAX_WITHDRAWALS = 3;

    public SavingsAccount(double initialBalance) {
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
        if (withdrawalCount >= MAX_WITHDRAWALS) {
            System.out.println("Withdrawal limit reached!");
            return;
        }

        if (amount <= balance) {
            balance -= amount;
            withdrawalCount++;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

}
