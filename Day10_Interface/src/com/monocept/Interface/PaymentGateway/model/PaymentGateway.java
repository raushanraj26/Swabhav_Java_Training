package com.monocept.Interface.PaymentGateway.model;

public interface PaymentGateway {

    void pay(double amount);

    void refund(double amount);
}
