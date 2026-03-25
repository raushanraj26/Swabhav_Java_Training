package com.monocept.ProductInventory.model;

public class GroceryProduct extends Product {
    private String expiryDate;

    public GroceryProduct(int id, String name, double price, String expiryDate) {
        super(id, name, "Grocery", price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + " | Expiry: " + expiryDate;
    }
}