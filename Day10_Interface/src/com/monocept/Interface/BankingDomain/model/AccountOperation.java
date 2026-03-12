package com.monocept.Interface.BankingDomain.model;

public interface AccountOperation {
	void deposit(double amount);
	void withdraw(double amount);
	void checkBalance();

}
