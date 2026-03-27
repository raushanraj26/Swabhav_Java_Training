package com.monocept.FilterAssignments;
import java.util.*;

class Product {
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class ProductFilter {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 60000),
            new Product("Mouse", 300),
            new Product("Headphones", 1500)
        );

        products.stream()
                .filter(p -> p.price > 500)
                .forEach(p -> System.out.println(p.name + " " + p.price));
    }
}