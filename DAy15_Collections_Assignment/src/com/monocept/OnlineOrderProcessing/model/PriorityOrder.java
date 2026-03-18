package com.monocept.OnlineOrderProcessing.model;


public class PriorityOrder extends Order {

    public PriorityOrder(int id, String customerName, double amount) {
        super(id, customerName, amount);
    }

    @Override
    public String getType() {
        return "Priority";
    }
}