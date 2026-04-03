package com.monocept.SRP_Assignment.Ecommerce.model;

public class Product {
    private int id;
    private String name;
    private double basePrice;

    public Product(int id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
