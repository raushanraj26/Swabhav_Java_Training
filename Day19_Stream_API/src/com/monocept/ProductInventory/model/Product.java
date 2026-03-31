package com.monocept.ProductInventory.model;

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private int stock;
    private int soldUnits;

    public Product(int productId, String name, String category,
                   double price, int stock, int soldUnits) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.soldUnits = soldUnits;
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public int getSoldUnits() { return soldUnits; }

    @Override
    public String toString() {
        return productId + " | " + name + " | " + category +
               " | Price: " + price +
               " | Stock: " + stock +
               " | Sold: " + soldUnits;
    }
}