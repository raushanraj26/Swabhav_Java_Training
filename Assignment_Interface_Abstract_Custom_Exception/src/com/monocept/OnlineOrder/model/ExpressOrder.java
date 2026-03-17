package com.monocept.OnlineOrder.model;


public class ExpressOrder extends Order {

    public ExpressOrder(int orderId, String customerName, double orderAmount) {
        super(orderId, customerName, orderAmount);
        System.out.println("ExpressOrder Constructor Executed");
    }

    @Override
    public void processOrder() {
        System.out.println("Processing Express Order (Fast Delivery)...");
    }
}