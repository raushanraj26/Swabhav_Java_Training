package com.monocept.ProductInventory.model;
import java.util.*;
import java.util.stream.Collectors;

public class Service {

    private List<Product> products = new ArrayList<>();

    // Add product
    public void addProduct(Product p) {
        products.add(p);
    }

    // Check empty
    private void checkEmpty() {
        if (products.isEmpty()) {
            throw new RuntimeException("No products available!");
        }
    }

    // 1. Out of stock
    public void showOutOfStock() {
        checkEmpty();
        products.stream()
                .filter(p -> p.getStock() == 0)
                .forEach(System.out::println);
    }

    // 2. Group by category
    public void groupByCategory() {
        checkEmpty();
        Map<String, List<Product>> map =
                products.stream()
                        .collect(Collectors.groupingBy(p->p.getCategory()));

        map.forEach((cat, list) -> {
            System.out.println("\nCategory: " + cat);
            list.forEach(System.out::println);
        });
    }

    // 3. Total stock value
    public void totalStockValue() {
        checkEmpty();
        double total =
                products.stream()
                        .mapToDouble(p -> p.getPrice() * p.getStock())
                        .sum();

        System.out.println("Total Stock Value: " + total);
    }

    // 4. Highest sold product
    public void highestSoldProduct() {
        checkEmpty();
        Product p =
                products.stream()
                        .max(Comparator.comparingInt(Product::getSoldUnits))
                        .orElse(null);

        System.out.println("Highest Sold: " + p);
    }

    // 5. Sort by sold units (desc)
    public void sortBySoldUnits() {
        checkEmpty();
        products.stream()
                .sorted((a, b) -> b.getSoldUnits() - a.getSoldUnits())
                .forEach(System.out::println);
    }

    // 6. Name -> Stock map
    public void nameStockMap() {
        checkEmpty();
        Map<String, Integer> map =
                products.stream()
                        .collect(Collectors.toMap(
                                Product::getName,
                                Product::getStock
                        ));

        map.forEach((name, stock) ->
                System.out.println(name + " -> " + stock));
    }

    // 7. All stock > 0
    public void checkAllStock() {
        checkEmpty();
        boolean result =
                products.stream()
                        .allMatch(p -> p.getStock() > 0);

        System.out.println("All stock > 0? " + result);
    }
}