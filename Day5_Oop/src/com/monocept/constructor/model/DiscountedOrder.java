package com.monocept.constructor.model;

public class DiscountedOrder extends Order {

    private double discountPercent;

    public DiscountedOrder(Product product, int quantity, double discountPercent) {

        super(product, quantity);   // parent calculates base total first

        if (discountPercent < 0) {
            System.out.println("Invalid discount! Setting to 0%");
            this.discountPercent = 0;
        } else {
            this.discountPercent = discountPercent;
        }

        double discountAmount = totalAmount * (this.discountPercent / 100);
        totalAmount = totalAmount - discountAmount;
    }

    @Override
    public void displayOrder() {
        super.displayOrder();
        System.out.println("Discount Applied: " + discountPercent + "%");
        System.out.println("Final Amount After Discount: " + totalAmount);
    }
}