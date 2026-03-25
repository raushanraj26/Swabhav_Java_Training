package com.monocept.ProductInventory.model;



import java.util.*;


public class InventoryManager {

    // No duplicates → TreeSet
    private Set<Product> products = new TreeSet<>();

    // Category mapping
    private Map<String, List<Product>> categoryMap = new HashMap<>();

    // Return queue
    private Queue<Product> returnQueue = new LinkedList<>();

    // Add product
    public void addProduct(Product p) {
        if (products.add(p)) {
            categoryMap
                .computeIfAbsent(p.getCategory(), k -> new ArrayList<>())
                .add(p);
        } else {
            System.out.println("Duplicate product not allowed: " + p.getId());
        }
    }

    // Display products (natural sorting)
    public void displayProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Display by category
    public void displayByCategory() {
        for (String category : categoryMap.keySet()) {
            System.out.println("\nCategory: " + category);
            for (Product p : categoryMap.get(category)) {
                System.out.println(p);
            }
        }
    }

    // Custom sorting
    public void sortByComparator(Comparator<Product> comp) {
        List<Product> list = new ArrayList<>(products);
        list.sort(comp);

        for (Product p : list) {
            System.out.println(p);
        }
    }

    // Add return request
    public void addReturn(Product p) {
        returnQueue.add(p);
    }

    // Process returns (FIFO)
    public void processReturns() {
        while (!returnQueue.isEmpty()) {
            Product p = returnQueue.poll();
            System.out.println("Processing return: " + p);
        }
    }

    // Remove invalid/expired products safely
    public void removeLowPriceProducts(double threshold) {
        Iterator<Product> it = products.iterator();

        while (it.hasNext()) {
            Product p = it.next();
            if (p.getPrice() < threshold) {
                it.remove();
            }
        }
    }
}