
//we dont make it ABSTRACT because we can create object of Notification alone.that is by default send() method is defining in the notification class

package com.monocept.Inheritance.model;

public class Notification {
	  // Fields (common for all notifications)
    protected String recipient;
    protected String message;

    // Constructor
    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    // Common logging method (shared behavior)
    public void logNotification() {
        System.out.println("Logging notification for: " + recipient);
    }

    // Default send method (can be overridden)
    public void send() {
        System.out.println("Sending notification...");
    }

}
