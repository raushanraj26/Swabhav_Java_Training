package com.monocept.SRP_Assignment.Ecommerce.model;

public class StockManager {

    private int stock;

    public StockManager(int initialStock) {
        this.stock = initialStock;
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
        }
    }

    public void removeStock(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("Invalid stock removal!");
        }
    }

    public int getStock() {
        return stock;
    }
}