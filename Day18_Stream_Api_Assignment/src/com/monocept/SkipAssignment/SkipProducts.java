package com.monocept.SkipAssignment;
import java.util.*;

class Product {
    String name;
    int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class SkipProducts {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Pen", 100),
                new Product("Bag", 700),
                new Product("Shoes", 1200),
                new Product("Book", 300),
                new Product("Watch", 900)
        );

        products.stream()
                .filter(p -> p.price > 500)
                .skip(2)
                .forEach(p -> System.out.println(p.name + " - " + p.price));
    }
}
