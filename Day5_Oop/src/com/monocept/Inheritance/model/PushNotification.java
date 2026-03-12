package com.monocept.Inheritance.model;

public class PushNotification extends Notification {

    // Constructor
    public PushNotification(String recipient, String message) {
        super(recipient, message);   // Constructor chaining
    }

    // Override send() method
    @Override
    public void send() {

        // Call common logging method from parent
        super.logNotification();

        // Push notification specific behavior
        System.out.println("Push alert sent to: " + recipient);
        System.out.println("Message: " + message);
    }
}
