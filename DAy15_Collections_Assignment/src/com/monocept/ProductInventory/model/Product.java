package com.monocept.ProductInventory.model;

public abstract class Product implements Comparable<Product> {
    protected int id;
    protected String name;
    protected String category;
    protected double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    // Natural ordering → by ID
    @Override
    public int compareTo(Product p) {
        return this.id - p.id;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | " + price;
    }

    // Avoid duplicate products
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;

        Product p = (Product) obj;
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}