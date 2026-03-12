package com.monocept.constructor.test;
import java.util.Scanner;
import com.monocept.constructor.model.BankAccount;
import com.monocept.constructor.model.PremiumAccount;
public class BankTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------- BANK ACCOUNT SYSTEM------");
            System.out.println("1. Create Normal Account");
            System.out.println("2. Create Premium Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();   // clear buffer

            switch (choice) {

                case 1:
                    System.out.println("\n--- Create Normal Account ---");

                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    BankAccount account = new BankAccount(accNo, name, balance);

                    System.out.println("\nAccount Created Successfully!");
                    account.displayAccount();
                    break;

                case 2:
                    System.out.println("\n--- Create Premium Account ---");

                    System.out.print("Enter Account Number: ");
                    String pAccNo = sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String pName = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double pBalance = sc.nextDouble();

                    PremiumAccount pAccount = new PremiumAccount(pAccNo, pName, pBalance);

                    System.out.println("\nPremium Account Created Successfully!");
                    pAccount.displayAccount();
                    break;

                case 3:
                    System.out.println("Thank you for using Bank System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }

}
