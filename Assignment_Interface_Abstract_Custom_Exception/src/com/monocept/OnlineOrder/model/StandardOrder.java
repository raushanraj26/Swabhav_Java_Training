package com.monocept.OnlineOrder.model;
public class StandardOrder extends Order {

    public StandardOrder(int orderId, String customerName, double orderAmount) {
        super(orderId, customerName, orderAmount);
        System.out.println("StandardOrder Constructor Executed");
    }

    @Override
    public void processOrder() {
        System.out.println("Processing Standard Order...");
    }
}
