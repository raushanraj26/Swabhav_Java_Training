package com.monocept.IMS.model.Notification;

public class EmailNotification implements Notifier {
	@Override
	public void sendNotification(String msg) {
		
		System.out.println("Email is Sent Successfully! and Message is: "+msg);
	}


}
