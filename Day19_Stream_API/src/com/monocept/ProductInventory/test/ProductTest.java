package com.monocept.ProductInventory.test;
com.monocept.ProductInventory.model.*;


import java.util.Scanner;

import com.monocept.ProductInventory.model.Service;

public class ProductTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        int choice;

        do {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Out of Stock");
            System.out.println("3. Group by Category");
            System.out.println("4. Total Stock Value");
            System.out.println("5. Highest Sold Product");
            System.out.println("6. Sort by Sold Units");
            System.out.println("7. Name -> Stock Map");
            System.out.println("8. Check All Stock > 0");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next();
            }

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        sc.nextLine();

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Category: ");
                        String category = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Enter Stock: ");
                        int stock = sc.nextInt();

                        System.out.print("Enter Sold Units: ");
                        int sold = sc.nextInt();

                        service.addProduct(
                                new Product(id, name, category, price, stock, sold)
                        );

                        System.out.println("Product added!");
                        break;

                    case 2:
                        service.showOutOfStock();
                        break;

                    case 3:
                        service.groupByCategory();
                        break;

                    case 4:
                        service.totalStockValue();
                        break;

                    case 5:
                        service.highestSoldProduct();
                        break;

                    case 6:
                        service.sortBySoldUnits();
                        break;

                    case 7:
                        service.nameStockMap();
                        break;

                    case 8:
                        service.checkAllStock();
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 9);
    }
}