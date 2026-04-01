package com.monocept.IMS.model.Notification;

public class SMSNotification  implements Notifier {
	@Override
	public void sendNotification(String msg) {
		
		System.out.println("SMS is Sent Successfully! and Message is: "+msg);
	}

}
