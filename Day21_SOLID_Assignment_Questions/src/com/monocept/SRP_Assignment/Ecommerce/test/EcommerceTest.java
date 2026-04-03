package com.monocept.SRP_Assignment.Ecommerce.test;
import com.monocept.SRP_Assignment.Ecommerce.model.*;

import java.util.Scanner;

import java.util.*;

public class EcommerceTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, Product> products = new HashMap<>();
        Map<Integer, StockManager> stockMap = new HashMap<>();

        PriceCalculator calculator = new PriceCalculator();
        ProductPrinter printer = new ProductPrinter();

        int choice;

        while (true) {

            System.out.println("\n---- E-Commerce System----------");
            System.out.println("1. Add Product");
            System.out.println("2. Add Stock");
            System.out.println("3. Remove Stock");
            System.out.println("4. Calculate Final Price");
            System.out.println("5. Show Product Details");
            System.out.println("6. Show All Products");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            // Choice validation
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter number only.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Add Product
                    System.out.print("Enter Product ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    int id = sc.nextInt();

                    if (products.containsKey(id)) {
                        System.out.println("Product ID already exists!");
                        break;
                    }

                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    // remove extra spaces
                    name = name.trim();

                    if (name.isEmpty()) {
                        System.out.println("Product name cannot be empty!");
                        break;
                    }

                    if (!name.matches("[a-zA-Z ]+")) {
                        System.out.println("Name should contain only letters!");
                        break;
                    }
                    
                    
                    System.out.print("Enter Base Price: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid price!");
                        sc.next();
                        break;
                    }
                    double price = sc.nextDouble();

                    if (price < 0) {
                        System.out.println("Price cannot be negative!");
                        break;
                    }

                    System.out.print("Enter Initial Stock: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid stock!");
                        sc.next();
                        break;
                    }
                    int stock = sc.nextInt();

                    if (stock < 0) {
                        System.out.println("Stock cannot be negative!");
                        break;
                    }

                    products.put(id, new Product(id, name, price));
                    stockMap.put(id, new StockManager(stock));

                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    // Add Stock
                    System.out.print("Enter Product ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    id = sc.nextInt();

                    if (!products.containsKey(id)) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter quantity to add: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid quantity!");
                        sc.next();
                        break;
                    }

                    int addQty = sc.nextInt();

                    if (addQty <= 0) {
                        System.out.println("Quantity must be positive!");
                        break;
                    }

                    stockMap.get(id).addStock(addQty);
                    System.out.println("Stock added!");
                    break;

                case 3:
                    // Remove Stock
                    System.out.print("Enter Product ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    id = sc.nextInt();

                    if (!products.containsKey(id)) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter quantity to remove: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid quantity!");
                        sc.next();
                        break;
                    }

                    int removeQty = sc.nextInt();

                    if (removeQty <= 0) {
                        System.out.println("Quantity must be positive!");
                        break;
                    }

                    stockMap.get(id).removeStock(removeQty);
                    break;

                case 4:
                    // Calculate Final Price
                    System.out.print("Enter Product ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    id = sc.nextInt();

                    if (!products.containsKey(id)) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter Discount (%): ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid discount!");
                        sc.next();
                        break;
                    }
                    double discount = sc.nextDouble();

                    System.out.print("Enter Tax (%): ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid tax!");
                        sc.next();
                        break;
                    }
                    double tax = sc.nextDouble();

                    if (discount < 0 || tax < 0) {
                        System.out.println("Values cannot be negative!");
                        break;
                    }

                    double finalPrice = calculator.calculateFinalPrice(products.get(id), discount, tax);
                    System.out.println("Final Price: " + finalPrice);
                    break;

                case 5:
                    // Show Product Details
                    System.out.print("Enter Product ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        sc.next();
                        break;
                    }
                    id = sc.nextInt();

                    if (!products.containsKey(id)) {
                        System.out.println("Product not found!");
                        break;
                    }

                    Product p = products.get(id);
                    StockManager sm = stockMap.get(id);

                    double fp = calculator.calculateFinalPrice(p, 10, 18); //(product,discount,tax)
                    printer.printProduct(p, fp, sm.getStock());
                    break;

                case 6:
                    // Show All Products
                    if (products.isEmpty()) {
                        System.out.println("No products available!");
                        break;
                    }

                    for (int key : products.keySet()) {
                        Product prod = products.get(key);
                        System.out.println("ID: " + prod.getId() + " | Name: " + prod.getName());
                    }
                    break;

                case 7:
                    System.out.println("Exit");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}