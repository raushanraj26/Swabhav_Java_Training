package com.monocept.ProductInventory.model;
public class ElectronicProduct extends Product {
    private int warrantyYears;

    public ElectronicProduct(int id, String name, double price, int warrantyYears) {
        super(id, name, "Electronic", price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    public String toString() {
        return super.toString() + " | Warranty: " + warrantyYears + " years";
    }
}