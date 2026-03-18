package com.monocept.OnlineOrderProcessing.model;

public class RegularOrder extends Order {

    public RegularOrder(int id, String customerName, double amount) {
        super(id, customerName, amount);
    }

    @Override
    public String getType() {
        return "Regular";
    }
}