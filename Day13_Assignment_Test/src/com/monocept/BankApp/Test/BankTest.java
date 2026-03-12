package com.monocept.BankApp.Test;

import java.util.Scanner;
import com.monocept.BankApp.model.*;

public class BankTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account[] accounts = new Account[10];
        int count = 0;

        while(true) {

            System.out.println("\n----- BANK MENU -----");
            System.out.println("1 Create Savings Account");
            System.out.println("2 Create Current Account");
            System.out.println("3 Deposit");
            System.out.println("4 Withdraw");
            System.out.println("5 Display Accounts");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");

            try {

                int choice = sc.nextInt();

                switch(choice) {

                case 1:

                    if(count == accounts.length) {
                        System.out.println("Account storage full");
                        break;
                    }

                    System.out.print("Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Balance: ");
                    double balance = sc.nextDouble();

                    System.out.print("Minimum Balance: ");
                    double minBal = sc.nextDouble();

                    accounts[count++] =
                            new SavingsAccount(accNo, name, balance, minBal);

                    System.out.println("Savings Account Created");
                    break;

                case 2:

                    if(count == accounts.length) {
                        System.out.println("Account storage full");
                        break;
                    }

                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Holder Name: ");
                    name = sc.nextLine();

                    System.out.print("Balance: ");
                    balance = sc.nextDouble();

                    System.out.print("Overdraft Limit: ");
                    double overdraft = sc.nextDouble();

                    accounts[count++] =
                            new CurrentAccount(accNo, name, balance, overdraft);

                    System.out.println("Current Account Created");
                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Deposit Amount: ");
                    double amount = sc.nextDouble();

                    boolean found = false;

                    for(int i = 0; i < count; i++) {

                        if(accounts[i].getAccountNumber() == accNo) {

                            accounts[i].deposit(amount);
                            System.out.println("Deposit successful");
                            found = true;
                            break;
                        }
                    }

                    if(!found)
                        System.out.println("Account not found");

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Withdraw Amount: ");
                    amount = sc.nextDouble();

                    found = false;

                    for(int i = 0; i < count; i++) {

                        if(accounts[i].getAccountNumber() == accNo) {

                            accounts[i].withdraw(amount);
                            found = true;
                            break;
                        }
                    }

                    if(!found)
                        System.out.println("Account not found");

                    break;

                case 5:

                    for(int i = 0; i < count; i++) {

                        System.out.println("\n------------------");
                        accounts[i].displayDetails();
                    }

                    break;

                case 6:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid choice");
                }

            } catch(Exception e) {

                System.out.println("Invalid input. Please try again.");
                sc.nextLine();
            }
        }
    }
}