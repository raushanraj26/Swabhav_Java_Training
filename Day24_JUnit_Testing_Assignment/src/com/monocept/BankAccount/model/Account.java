package com.monocept.BankAccount.model;

public class Account {
	private Double balance;
	 public Account(Double balance) {
		 if(balance<0) {
			 throw new IllegalArgumentException("Initial balance cannot be negative");
			 
		 }
		 this.balance=balance;
	 }
	 
	 public void deposit(Double amount) {
		 if(amount<=0) {
			 throw new IllegalArgumentException("Deposit amount must be positive");
			 
		 }
		 balance =balance + amount;
	 }
	 
	 public void withdraw(Double amount) {
		 if(amount<=0) {
			 throw new IllegalArgumentException("Withdraw amount must be positive");
			 
		 }
		 if(getBalance()<amount) {
			 throw new IllegalArgumentException("Balnace insufficient! ");
			 
		 }
		 balance =balance + amount;
	 }
	 
	 public Double getBalance() {
		 return balance;
	 }

}
