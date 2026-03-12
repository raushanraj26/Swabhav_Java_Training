package com.monocept.Encapsulation.model;

public class EcommerceInventory {


    
    private final int productId;   // cannot change
    private String productName;
    private double price;
    private int stockQuantity;
    private boolean isDiscontinued;

    // Constructor
    public EcommerceInventory(int id, String name, double price, int stock) {

        productId = id;
        productName = name;

        if (price >= 0)
            this.price = price;
        else {
            System.out.println("Price cannot be negative. Setting price to 0.");
            this.price = 0;
        }

        if (stock >= 0)
            stockQuantity = stock;
        else {
            System.out.println("Stock cannot be negative. Setting stock to 0.");
            stockQuantity = 0;
        }

        isDiscontinued = false;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    // Increase Stock
    public void increaseStock(int quantity) {

        if (isDiscontinued) {
            System.out.println("Cannot increase stock. Product is discontinued.");
            return;
        }

        if (quantity > 0)
            stockQuantity = stockQuantity + quantity;
        else
            System.out.println("Quantity must be positive.");
    }

    // Reduce Stock
    public void reduceStock(int quantity) {

        if (isDiscontinued) {
            System.out.println("Cannot reduce stock. Product is discontinued.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        if (quantity > stockQuantity) {
            System.out.println("Not enough stock available.");
            return;
        }

        stockQuantity = stockQuantity - quantity;
    }

    // admin can Update Price 
    public void updatePrice(double newPrice, boolean isAdmin) {

        if (!isAdmin) {
            System.out.println("Only admin can update price.");
            return;
        }

        if (newPrice < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        price = newPrice;
    }

    // Discontinue Product
    public void discontinueProduct() {
        isDiscontinued = true;
        System.out.println("Product discontinued successfully.");
    }

    
    public void displayProduct() {

        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stockQuantity);
        System.out.println("Discontinued: " + isDiscontinued);
    }
}
