package com.monocept.IMS.model.ServiceClass;

import java.util.ArrayList;
import java.util.List;

import com.monocept.IMS.model.Product.Product;
import com.monocept.IMS.model.Notification.Notifier;

public class InventoryService {

    private List<Product> products;
    private List<Notifier> notifierChannel;

    // Constructor
    public InventoryService() {
        products = new ArrayList<>();
        notifierChannel = new ArrayList<>();
    }

    // Add Product (prevent duplicate ID)
    public void addProduct(Product p) {

        if (findProductById(p.getId()) != null) {
            System.out.println("Product with this ID already exists!");
            return;
        }

        products.add(p);
        System.out.println("Product added!");
    }

    // Add Notifier
    public void addNotifier(Notifier notifier) {
        notifierChannel.add(notifier);
        System.out.println("Notifier added!");
    }

    // Find Product by ID
    public Product findProductById(int id) {

        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Add Stock
    public void addStock(Product p, int qty) {

        if (qty <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }

        Product existing = findProductById(p.getId());

        if (existing == null) {
            System.out.println("Product not found!");
            return;
        }

        existing.setStock(existing.getStock() + qty);
        System.out.println("STock added and Stock become"+existing.getStock());
    }

    // Remove Stock
    public void removeStock(Product p, int qty) {

        if (qty <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }

        Product existing = findProductById(p.getId());

        if (existing == null) {
            System.out.println("Product not found!");
            return;
        }

        if (existing.getStock() < qty) {
            System.out.println("Less stock! Cannot remove.");
            return;
        }

        
        existing.setStock(existing.getStock() - qty);
        System.out.println("STock removed and Stock become"+existing.getStock());

        // Check threshold 
        if (existing.getStock() <= existing.getThreshold()) {

            String msg = "Low stock alert! Product: " +
                         existing.getName() +
                         ", Remaining: " + existing.getStock();

            if (notifierChannel.isEmpty()) {
                System.out.println("No notifier configured so can't send Notification");
            } else {
                for (Notifier n : notifierChannel) {
                    n.sendNotification(msg);
                }
            }
        }
        //reoorder
        int reorderQty = existing.getThreshold();

        existing.setStock(existing.getStock() + reorderQty);

        System.out.println("Auto Reorder done! Added " + reorderQty +
                           " units to " + existing.getName());
    }

    // Show All Products
    public void showAllProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }

        System.out.println("ID\tName\tPrice\tStock\tType\tExpiry");

        for (Product p : products) {
            p.showDetails(); // polymorphism
        }
    }
}