package com.monocept.Interface.PaymentGateway.test;

import java.util.Scanner;
import com.monocept.Interface.PaymentGateway.model.*;

public class ECommerceTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== E-Commerce Payment System =====");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Net Banking");
            System.out.println("4. Exit");
            System.out.print("Select Payment Method: ");

            choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            PaymentGateway gateway = null;

            switch (choice) {
                case 1:
                    gateway = new CreditCard();
                    break;
                case 2:
                    gateway = new UPI();
                    break;
                case 3:
                    gateway = new NetBanking();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            Checkout checkout = new Checkout(gateway);

            System.out.println("\n1. Pay");
            System.out.println("2. Refund");
            System.out.print("Select Operation: ");

            int operation = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            switch (operation) {
                case 1:
                    checkout.makePayment(amount);
                    break;
                case 2:
                    checkout.processRefund(amount);
                    break;
                default:
                    System.out.println("Invalid operation!");
            }

        } while (true);

        sc.close();
    }
}
