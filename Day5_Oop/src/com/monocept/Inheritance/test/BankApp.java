package com.monocept.Inheritance.test;

import java.util.Scanner;
import com.monocept.Inheritance.model.*;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       

        System.out.println("Select Account Type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("Enter your choice: ");
        int typeChoice = sc.nextInt();

        // Ask common details
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();   

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccountSystem account = null;

        if (typeChoice == 1) {

            double minBalance = 1000;   // Admin fixed rule
            account = new SavingsAccount(accNo, name, balance, minBalance);
            System.out.println("Savings Account Created (Min Balance = 1000)");

        } else if (typeChoice == 2) {

            double overdraftLimit = 2000;  // Admin fixed rule
            account = new CurrentAccount(accNo, name, balance, overdraftLimit);
            System.out.println("Current Account Created (Overdraft = 2000)");

        } else {

            System.out.println("Invalid Account Type!");
            sc.close();
            return;
        }

        int choice;

        do {
        	System.out.println("---------------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Details");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.displayDetails();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
