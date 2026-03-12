package com.monocept.Inheritance.test;

import java.util.Scanner;
import com.monocept.Inheritance.model.*;

public class NotificationTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Notification notification = null;
		int choice;

		do {
			System.out.println("-------Notification System ---");
			System.out.println("1. Email Notification");
			System.out.println("2. SMS Notification");
			System.out.println("3. Push Notification");
			System.out.println("4. exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {

			case 1: {
				System.out.print("Enter recipient: ");
				String recipient = sc.nextLine();

				System.out.print("Enter message: ");
				String message = sc.nextLine();
				notification = new EmailNotification(recipient, message);
				notification.send();
				break;
			}

			case 2: {
				System.out.print("Enter recipient: ");
				String recipient = sc.nextLine();

				System.out.print("Enter message: ");
				String message = sc.nextLine();
				notification = new SMSNotification(recipient, message);
				notification.send();
				break;
			}

			case 3: {
				System.out.print("Enter recipient: ");
				String recipient = sc.nextLine();

				System.out.print("Enter message: ");
				String message = sc.nextLine();
				notification = new PushNotification(recipient, message);
				notification.send();
				break;
			}
			case 4: {
				System.out.println("Thank You!");
				break;
			}
			default: {
				System.out.println("Invalid choice!");
			}


	        
	        
			}
		} while (choice != 4);

		sc.close();
	}
}