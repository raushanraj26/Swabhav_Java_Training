package com.monocept.Inheritance.model;

public class SMSNotification extends Notification {

    // Constructor
    public SMSNotification(String recipient, String message) {
        super(recipient, message);   // Constructor chaining
    }

    // Override send() method
    @Override
    public void send() {

        // Call common logging method from parent
        super.logNotification();

        // SMS specific behavior
        System.out.println("SMS sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}