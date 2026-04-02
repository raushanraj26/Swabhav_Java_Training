package com.monocept.IMS.test;

import java.util.Scanner;

import com.monocept.IMS.model.Product.Product;
import com.monocept.IMS.model.ServiceClass.InventoryService;
import com.monocept.IMS.model.Notification.*;

public class InventoryManagementTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InventoryService service = new InventoryService();

        int choice=-1;

        do {
            System.out.println("\n---- Inventory Management System ----");
            System.out.println("1. Add Product");
            System.out.println("2. Add Stock");
            System.out.println("3. Remove Stock");
            System.out.println("4. Show All Products");
            System.out.println("5. Add Notification Channel");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            // choice validation
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter number only.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        if (price < 0) {
                            System.out.println("Price cannot be negative!");
                           continue; // go back to menu / retry
                        }

                        System.out.print("Enter Initial Stock: ");
                        int stock = scanner.nextInt();
                        if (stock < 0) {
                            System.out.println("Stock cannot be negative!");
                            continue;
                        }

                        System.out.print("Enter Threshold: ");
                        int threshold = scanner.nextInt();
                        if (threshold < 0) {
                            System.out.println("Threshold cannot be negative!");
                           continue;
                        }

                        Product p = new Product(id, name, price, stock, threshold);
                        service.addProduct(p);


                    } catch (Exception e) {
                        System.out.println("Invalid input! Try again.");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Product ID: ");
                        int id = scanner.nextInt();

                        System.out.print("Enter Quantity to Add: ");
                        int qty = scanner.nextInt();
                        if (qty < 0) {
                            System.out.println("Quantity cannot be negative!");
                            continue;
                        }


                        Product p = service.findProductById(id);

                        if (p == null) {
                            System.out.println("Product not found!");
                        } else {
                            service.addStock(p, qty);
                           
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Product ID: ");
                        int id = scanner.nextInt();

                        System.out.print("Enter Quantity to Remove: ");
                        int qty = scanner.nextInt();
                        if (qty < 0) {
                            System.out.println("Quantity cannot be negative!");
                            continue;
                        }

                        Product p = service.findProductById(id);

                        if (p == null) {
                            System.out.println("Product not found!");
                        } else {
                            service.removeStock(p, qty);
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    service.showAllProducts();
                    break;

                case 5:
                    System.out.println("Select Notification Type:");
                    System.out.println("1. Email");
                    System.out.println("2. SMS");
                    System.out.print("Enter choice: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input!");
                        scanner.next();
                        break;
                    }

                    int type = scanner.nextInt();

                    switch (type) {
                        case 1:
                            service.addNotifier(new EmailNotification());
                            System.out.println("Email notifier added!");
                            break;

                        case 2:
                            service.addNotifier(new SMSNotification());
                            System.out.println("SMS notifier added!");
                            break;

                        default:
                            System.out.println("Invalid notifier choice!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}