package com.monocept.AbstractClass.Payment.test;

import java.util.Scanner;
import com.monocept.AbstractClass.Payment.model.*;

public class PaymentTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("\n===== Digital Payment System =====");
            System.out.println("1. Credit Card Payment (2% fee)");
            System.out.println("2. UPI Payment (No fee)");
            System.out.println("3. Wallet Payment (1% fee)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Exited...");
                break;
            }

            System.out.print("Enter Amount: ");
            amount = sc.nextDouble();

            Payment payment = null;   // Polymorphic reference

            switch (choice) {

                case 1:
                    payment = new CreditCardPayment(amount);
                    break;

                case 2:
                    payment = new UPIPayment(amount);
                    break;

                case 3:
                    payment = new Walletpayment(amount);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            // Polymorphism in action
            payment.processPayment();
            payment.generateReceipt();

        } while (true);

        sc.close();
    }
}