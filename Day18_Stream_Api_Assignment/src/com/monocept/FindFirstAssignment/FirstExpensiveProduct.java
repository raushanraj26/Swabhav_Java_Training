package com.monocept.FindFirstAssignment;
import java.util.*;

class Product {
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class FirstExpensiveProduct {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Pen", 50),
                new Product("Shoes", 1200),
                new Product("Bag", 700)
        );

        Optional<Product> result = products.stream()
                .filter(p -> p.price > 500)
                .findFirst();

        result.ifPresent(p -> System.out.println(p.name + " - " + p.price));
    }
}