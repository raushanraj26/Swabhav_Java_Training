package com.monocept.OnlineOrderProcessing.model;

public abstract class Order {
    protected int id;
    protected String customerName;
    protected double amount;

    public Order(int id, String customerName, double amount) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + customerName +
                ", Amount: " + amount +
                ", Type: " + getType();
    }
}