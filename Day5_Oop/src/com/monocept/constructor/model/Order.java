package com.monocept.constructor.model;

public class Order {

    private static int counter = 1000;

    protected int orderId;
    protected Product product;
    protected int quantity;
    protected double totalAmount;

    // Constructor
    public Order(Product product, int quantity) {

        this.orderId = ++counter;

        if (product == null) {
            System.out.println("Order must have a product!");
            return;
        }

        this.product = product;

        if (quantity <= 0) {
            System.out.println("Invalid quantity! Setting quantity = 1");
            this.quantity = 1;
        } else {
            this.quantity = quantity;
        }

        // Total calculated at creation time
        this.totalAmount = this.product.getPrice() * this.quantity;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Amount: " + totalAmount);
    }
}