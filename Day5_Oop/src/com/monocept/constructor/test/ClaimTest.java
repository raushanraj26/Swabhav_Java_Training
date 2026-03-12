package com.monocept.constructor.test;

import java.util.Scanner;
import com.monocept.constructor.model.InsuranceClaim;
import com.monocept.constructor.model.CorporateClaim;

public class ClaimTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ INSURANCE CLAIM SYSTEM----------");
            System.out.println("1. Create Normal Claim");
            System.out.println("2. Create Corporate Claim");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Normal Claim ---");

                    System.out.print("Enter Policy Number: ");
                    String policy = sc.nextLine();

                    System.out.print("Enter Claim Amount: ");
                    double amount = sc.nextDouble();

                    InsuranceClaim claim = new InsuranceClaim(policy, amount);

                    System.out.println("\nClaim Created Successfully!");
                    claim.displayClaim();
                    break;

                case 2:
                    System.out.println("\n--- Corporate Claim ---");

                    System.out.print("Enter Policy Number: ");
                    String cPolicy = sc.nextLine();

                    System.out.print("Enter Claim Amount: ");
                    double cAmount = sc.nextDouble();

                    CorporateClaim corporate = new CorporateClaim(cPolicy, cAmount);

                    System.out.println("\nCorporate Claim Created Successfully!");
                    corporate.displayClaim();
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}