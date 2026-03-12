package com.monocept.Inheritance.model;



public class EmailNotification extends Notification {
	   // Constructor
    public EmailNotification(String recipient, String message) {
        super(recipient, message);   // Call parent constructor
    }

    // Overriding send() method
    @Override
    public void send() {

        // Call common logging method from parent
        super.logNotification();

        // Email specific logic
        System.out.println("Sending EMAIL to: " + recipient);
        System.out.println("Message: " + message);
    }

}
