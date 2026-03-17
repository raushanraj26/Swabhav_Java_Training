package com.monocept;

import java.util.*;

public class SortProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter product details " + (i+1));

            System.out.print("Enter category: ");
            String category = sc.nextLine();

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();

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