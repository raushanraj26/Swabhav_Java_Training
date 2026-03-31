package com.monocept.OnlineOrder.model;


public class Order {
    private int orderId;
    private String customerName;
    private String category;
    private double amount;
    private String status;

    public Order(int orderId, String customerName, String category, double amount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.category = category;
        this.amount = amount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return orderId + " | " + customerName + " | " + category + " | " + amount + " | " + status;
    }
}