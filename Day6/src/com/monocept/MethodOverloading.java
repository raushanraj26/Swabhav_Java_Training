package com.monocept;


class BankAccount {

    void deposit(int amount) {
        System.out.println("Deposited cash: " + amount);
    }

    void deposit(int amount, String mode) {
        System.out.println("Deposited " + amount + " via " + mode);
    }
}

public class MethodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BankAccount account = new BankAccount();

	        account.deposit(5000);
	        account.deposit(10000, "UPI");

	}

}
