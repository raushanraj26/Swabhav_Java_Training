package com.monocept.constructor.test;

import java.util.Scanner;
import com.monocept.constructor.model.*;

public class ECommerceTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        Product product = null;

        do {
            System.out.println("\n--------E-COMMERCE--------");
            System.out.println("1. Create Product");
            System.out.println("2. Create Order");
            System.out.println("3. Create Discounted Order");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter stock quantity: ");
                    int stock = sc.nextInt();

                    product = new Product(price, stock);
                    System.out.println("Product Created Successfully!");
                    product.displayProduct();
                    break;

                case 2:
                    if (product == null) {
                        System.out.println("Create product first!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    Order order = new Order(product, qty);
                    System.out.println("Order Created Successfully!");
                    order.displayOrder();
                    break;

                case 3:
                    if (product == null) {
                        System.out.println("Create product first!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int dQty = sc.nextInt();

                    System.out.print("Enter discount percentage: ");
                    double discount = sc.nextDouble();

                    DiscountedOrder dOrder = new DiscountedOrder(product, dQty, discount);
                    System.out.println("Discounted Order Created Successfully!");
                    dOrder.displayOrder();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}