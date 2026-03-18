package com.monocept;

import java.util.*;

public class SortProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        int n = 0;

        // ✅ Validate number of products
        while (true) {
            System.out.print("Enter number of products: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

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

            System.out.println("\nEnter product details " + (i+1));

            // ✅ Validate Category
            String category;
            while (true) {
                System.out.print("Enter category: ");
                category = sc.nextLine();

                if (category.matches("[a-zA-Z ]+") && !category.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Invalid category! Only letters allowed.");
                }
            }

            // ✅ Validate Product Name
            String name;
            while (true) {
                System.out.print("Enter product name: ");
                name = sc.nextLine();

                if (!name.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Product name cannot be empty!");
                }
            }

            // ✅ Validate Price
            double price;
            while (true) {
                System.out.print("Enter price: ");

                if (sc.hasNextDouble()) {
                    price = sc.nextDouble();
                    sc.nextLine();

                    if (price > 0) {
                        break;
                    } else {
                        System.out.println("Price must be greater than 0!");
                    }
                } else {
                    System.out.println("Invalid input! Enter a valid number.");
                    sc.nextLine();
                }
            }

            products.add(new Product(category, name, price));
        }

        // Sorting
        Collections.sort(products, new ProductComparator());

        System.out.println("\nSorted Product List:");

        for(Product p : products) {
            System.out.println(p);
        }

        sc.close();
    }
}


class Product {

    private String category;
    private String name;
    private double price;

    public Product(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return category + " | " + name + " | " + price;
    }
}


class ProductComparator implements Comparator<Product> {

    public int compare(Product p1, Product p2) {

        // Compare category first
        int categoryCompare = p1.getCategory().compareTo(p2.getCategory());

        if(categoryCompare != 0) {
            return categoryCompare;
        }

        // If category same → compare price
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}