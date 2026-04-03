package com.monocept.SRP_Assignment.Ecommerce.model;

public class ProductPrinter {

    public void printProduct(Product product, double finalPrice, int stock) {
        System.out.println("Product ID: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Final Price: " + finalPrice);
        System.out.println("Stock: " + stock);
    }
}