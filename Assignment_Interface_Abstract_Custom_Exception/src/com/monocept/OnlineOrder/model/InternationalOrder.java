package com.monocept.OnlineOrder.model;

public class InternationalOrder extends Order {

    public InternationalOrder(int orderId, String customerName, double orderAmount) {
        super(orderId, customerName, orderAmount);
        System.out.println("InternationalOrder Constructor Executed");
    }

    @Override
    public void processOrder() {
        System.out.println("Processing International Order (Customs + Shipping)...");
    }
}