package com.monocept.Interface.BankingDomain.test;

import java.util.Scanner;
import com.monocept.Interface.BankingDomain.model.*;
public class BankingTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n===== Banking System =====");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.println("3. Loan Account");
            System.out.println("4. Exit");
            System.out.print("Select Account Type: ");

            mainChoice = sc.nextInt();

            if (mainChoice == 4) {
                System.out.println("Exiting Banking System...");
                break;
            }

            AccountOperation account = null;

            switch (mainChoice) {

                case 1:
                    System.out.print("Enter Initial Balance for Savings: ");
                    account = new SavingsAccount(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Initial Balance for Current: ");
                    account = new CurrentAccount(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter Loan Amount: ");
                    account = new LoanAccount(sc.nextDouble());
                    break;

                default:
                    System.out.println("Invalid Account Choice!");
                    continue;
            }

            int operationChoice;

            do {
                System.out.println("\n--- Account Operations ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Back to Main Menu");
                System.out.print("Select Operation: ");

                operationChoice = sc.nextInt();

                switch (operationChoice) {

                    case 1:
                        System.out.print("Enter deposit amount: ");
                        account.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter withdraw amount: ");
                        account.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        account.checkBalance();
                        break;

                    case 4:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid Operation Choice!");
                }

            } while (operationChoice != 4);

        } while (mainChoice != 4);

        sc.close();
    }
}
