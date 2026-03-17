package com.monocept.OnlineOrder.model;


public abstract class Order implements OrderVerification {

    protected int orderId;
    protected String customerName;
    protected double orderAmount;

    static {
        System.out.println("Loading Order System Configuration...");
    }

    public Order(int orderId, String customerName, double orderAmount) {

        System.out.println("Order Constructor Executed");

        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

    public abstract void processOrder();

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Amount: " + orderAmount);
    }

    @Override
    public void verifyOrder() throws InvalidOrderException {

        if(orderId <= 0) {
            throw new InvalidOrderException("Invalid Order ID");
        }

        if(customerName == null || customerName.isEmpty()) {
            throw new InvalidOrderException("Customer name cannot be empty");
        }

        if(orderAmount <= 0) {
            throw new InvalidOrderException("Order amount must be positive");
        }

        System.out.println("Order Verified Successfully");
    }
}