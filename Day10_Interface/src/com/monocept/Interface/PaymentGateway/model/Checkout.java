package com.monocept.Interface.PaymentGateway.model;

public class Checkout {

    private PaymentGateway paymentMethod;

    public Checkout(PaymentGateway paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        paymentMethod.pay(amount);
    }

    public void processRefund(double amount) {
        paymentMethod.refund(amount);
    }
}
