package com.monocept;

import java.util.*;

public class SortTransaction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Transaction> transactions = new ArrayList<>();

        int n = 0;

        // ✅ Validate number of transactions
        while (true) {
            System.out.print("Enter number of transactions: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();

                if (n > 0) {
                    break;
                } else {
                    System.out.println("Number must be greater than 0!");
                }
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }


        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter transaction details " + (i+1));

            // ✅ Validate ID
            int id;
            while (true) {
                System.out.print("Enter ID: ");

                if (sc.hasNextInt()) {
                    id = sc.nextInt();

                    if (id > 0) {
                        break;
                    } else {
                        System.out.println("ID must be positive!");
                    }
                } else {
                    System.out.println("Invalid input! Enter a number.");
                    sc.nextLine();
                }
            }

            // ✅ Validate Amount
            double amount;
            while (true) {
                System.out.print("Enter amount: ");

                if (sc.hasNextDouble()) {
                    amount = sc.nextDouble();

                    if (amount > 0) {
                        break;
                    } else {
                        System.out.println("Amount must be greater than 0!");
                    }
                } else {
                    System.out.println("Invalid input! Enter a valid number.");
                    sc.nextLine();
                }
            }

            transactions.add(new Transaction(id, amount));
        }

        
        Collections.sort(transactions, new TransactionComparator());

        System.out.println("\nSorted Transactions:");

        for(Transaction t : transactions) {
            System.out.println(t);
        }

        sc.close();
    }
}


class Transaction {

    private int id;
    private double amount;

    public Transaction(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "ID: " + id + " Amount: " + amount;
    }
}


class TransactionComparator implements Comparator<Transaction> {

    public int compare(Transaction t1, Transaction t2) {

        //  descending
        int amountCompare = Double.compare(t2.getAmount(), t1.getAmount());

        if(amountCompare != 0) {
            return amountCompare;
        }

       
        return Integer.compare(t1.getId(), t2.getId());
    }
}