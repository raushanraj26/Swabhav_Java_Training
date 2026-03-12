package com.monocept.constructor.model;

public class Product {

    private static int counter = 100;

    private final int productId;   // immutable
    private double price;
    private int stockQuantity;

    // Parameterized constructor (price mandatory)
    public Product(double price, int stockQuantity) {

        this.productId = ++counter;

        if (price <= 0) {
            System.out.println("Invalid price! Setting default price = 1");
            this.price = 1;
        } else {
            this.price = price;
        }

        if (stockQuantity < 0) {
            System.out.println("Stock cannot be negative! Setting to 0.");
            this.stockQuantity = 0;
        } else {
            this.stockQuantity = stockQuantity;
        }
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stockQuantity);
    }
}