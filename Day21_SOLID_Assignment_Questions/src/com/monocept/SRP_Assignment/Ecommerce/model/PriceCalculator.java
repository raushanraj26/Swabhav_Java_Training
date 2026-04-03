package com.monocept.SRP_Assignment.Ecommerce.model;

public class PriceCalculator {

    public double calculateFinalPrice(Product product, double discountPercent, double taxPercent) {
        double price = product.getBasePrice();

        double discount = price * discountPercent / 100;
        double discountedPrice = price - discount;

        double tax = discountedPrice * taxPercent / 100;

        return discountedPrice + tax;
    }
}