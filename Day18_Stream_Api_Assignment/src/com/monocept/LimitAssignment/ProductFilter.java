package com.monocept.LimitAssignment;
import java.util.*;
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ProductFilter {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 70000),
            new Product(2, "Mouse", 300),
            new Product(3, "Keyboard", 800),
            new Product(4, "Monitor", 12000)
        );

        products.stream()
                .filter(p -> p.price > 500)
                .limit(2)
                .forEach(p -> System.out.println(p.name + " - " + p.price));
    }
}
