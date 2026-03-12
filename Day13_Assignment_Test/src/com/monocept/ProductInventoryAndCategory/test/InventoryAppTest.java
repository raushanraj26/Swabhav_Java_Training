package com.monocept.ProductInventoryAndCategory.test;

import java.util.Scanner;
import com.monocept.ProductInventoryAndCategory.model.*;

public class InventoryAppTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] inventory = new Product[n];
        int count = 0;

        while (true) {

            System.out.println("\n------ INVENTORY MENU ------");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                if (count >= n) {
                    System.out.println("Inventory is full!");
                    break;
                }

                try {

                    System.out.println("\n1. Electronics");
                    System.out.println("2. Clothing");
                    System.out.print("Choose category: ");
                    int category = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product ID: ");
                    String id = sc.nextLine();

                    if (id.isEmpty())
                        throw new IllegalArgumentException("Product ID cannot be empty");

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    if (name.isEmpty())
                        throw new IllegalArgumentException("Product Name cannot be empty");

                    System.out.print("Enter Base Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    if (price <= 0)
                        throw new IllegalArgumentException("Price must be greater than 0");

                    switch (category) {

                    case 1:

                        System.out.print("Enter Warranty Years: ");
                        int warranty = sc.nextInt();
                        sc.nextLine();

                        if (warranty < 0)
                            throw new IllegalArgumentException("Warranty cannot be negative");

                        inventory[count] = new Electronics(id, name, price, warranty);
                        count++;
                        System.out.println("Electronics product added successfully.");
                        break;

                    case 2:

                    	String size;

                    	while (true) {
                    	    System.out.print("Enter Size (S, M, L, XL, XXL): ");
                    	    size = sc.nextLine().trim().toLowerCase();

                    	    if (size.equals("s") || size.equals("m") || size.equals("l") 
                    	        || size.equals("xl") || size.equals("xxl")) {
                    	        break; // valid input
                    	    } else {
                    	        System.out.println("Invalid size! Please enter only S, M, L, XL, or XXL.");
                    	    }
                    	}
                        if (size.isEmpty())
                            throw new IllegalArgumentException("Size cannot be empty");

                        System.out.print("Enter Fabric Type: ");
                        String fabric = sc.nextLine();

                        if (fabric.isEmpty())
                            throw new IllegalArgumentException("Fabric type cannot be empty");

                        inventory[count] = new Clothing(id, name, price, size, fabric);
                        count++;
                        System.out.println("Clothing product added successfully.");
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid product category");
                    }

                } catch (Exception e) {

                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Product not added. Try again.");
                }

                break;

            case 2:

                if (count == 0) {
                    System.out.println("Inventory is empty.");
                    break;
                }

                System.out.println("\n------ PRODUCT INVENTORY ------");

                for (int i = 0; i < count; i++) {

                    inventory[i].displayDetails();
                    System.out.println("----------------------------");
                }

                break;

            case 3:

                System.out.println("Exit program");
                sc.close();
                return;

            default:

                System.out.println("Invalid menu choice. Try again.");
            }
        }
    }
}