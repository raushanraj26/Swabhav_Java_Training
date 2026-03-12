package com.monocept.Encapsulation.test;
import java.util.Scanner;

import com.monocept.Encapsulation.model.BankAccount;

public class BankAccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your full Name");
		String name=scanner.nextLine();
		System.out.println("Enetr Your Initial Amount");
		int amount=scanner.nextInt();


        BankAccount account1 = new BankAccount(name,amount);
        while(true) {
        	System.out.println("for Deposit press 1, for Withdraw press 2, for Check Balance press 3, for Apply Annual Interest press 4, for exit press 5 ");
        	int choice=scanner.nextInt();
        	switch(choice) {
        	case 1:{
        		System.out.println("Enter Amount");
        		double depositmoney=scanner.nextDouble();
        		account1.deposit(depositmoney);
        		break;
        	}
        	case 2:{
        		System.out.println("Enter Amount to be withdraw");
        		double withdrawmoney=scanner.nextDouble();
        		account1.withdraw(withdrawmoney);
        		break;
        		
        	}
        	case 3:{
        		System.out.println("Current Balance: " + account1.getBalance());
        		break;
        		
        	}
        	case 4:{
        		account1.applyAnnualInterest();
        		break;
        	}
        	case 5:{
        		System.out.println("Thank You!");
        		scanner.close();
        		
        		return;
        	}
        	default :{
        		System.out.println("Please Enter Valid number");
        		break;
        	}
        	}
        }

//        System.out.println("Account Number: " + account1.getAccountNumber());
//        System.out.println("Initial Balance: " + account1.getBalance());
//
//        account1.deposit(2000);
//        account1.withdraw(1000);
//
//        System.out.println("Balance after transactions: " + account1.getBalance());
//
//        account1.withdraw(10000);   
//
//        account1.applyAnnualInterest();
//
//        System.out.println("Final Balance: " + account1.getBalance());
        
    }

}
