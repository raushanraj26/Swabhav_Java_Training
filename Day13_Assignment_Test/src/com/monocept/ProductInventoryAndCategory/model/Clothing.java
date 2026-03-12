package com.monocept.ProductInventoryAndCategory.model;

public class Clothing extends Product {

    private String size;
    private String fabricType;

    public Clothing(String id, String name, double price, String size, String fabricType) {

        super(id, name, price);
        this.size = size;
        this.fabricType = fabricType;
    }

    @Override
    public void displayDetails() {

        System.out.println("Clothing Product");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getProductName());
        System.out.println("Price: " + getBasePrice());
        System.out.println("Size: " + size);
        System.out.println("Fabric: " + fabricType);
    }

}
