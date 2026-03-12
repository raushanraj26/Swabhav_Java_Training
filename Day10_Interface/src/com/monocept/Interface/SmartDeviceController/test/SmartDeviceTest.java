package com.monocept.Interface.SmartDeviceController.test;
import java.util.Scanner;
import com.monocept.Interface.SmartDeviceController.model.*;
public class SmartDeviceTest {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n===== Smart Home Menu =====");
	            System.out.println("1. Light");
	            System.out.println("2. Fan");
	            System.out.println("3. TV");
	            System.out.println("4. Speaker");
	            System.out.println("5. Exit");
	            System.out.print("Select device: ");

	            choice = sc.nextInt();

	            Controllable device = null;
	            String selectedMode = "";

	            switch (choice) {

	                case 1:
	                    device = new Light();
	                    System.out.println("Select Light Mode:");
	                    System.out.println("1. Dim");
	                    System.out.println("2. Bright");

	                    int lChoice = sc.nextInt();
	                    selectedMode = (lChoice == 1) ? "Dim" : "Bright";
	                    device.turnOn();

	                    

	                    device.setMode(selectedMode);
	                    device.turnOff();
	                    break;

	                case 2:
	                    device = new Fan();
	                    System.out.println("Select Fan Speed:");
	                    System.out.println("1. Low");
	                    System.out.println("2. Medium");
	                    System.out.println("3. High");

	                    int fChoice = sc.nextInt();

	                    switch (fChoice) {
	                        case 1: selectedMode = "Low"; break;
	                        case 2: selectedMode = "Medium"; break;
	                        case 3: selectedMode = "High"; break;
	                        default: System.out.println("Invalid choice");
	                    }
	                    device.turnOn();

	                    

	                    device.setMode(selectedMode);
	                    device.turnOff();
	                    break;

	                case 3:
	                    device = new TV();
	                    System.out.println("Select TV Mode:");
	                    System.out.println("1. HD");
	                    System.out.println("2. Full HD");

	                    int tChoice = sc.nextInt();
	                    selectedMode = (tChoice == 1) ? "HD" : "Full HD";
	                    device.turnOn();

	                   

	                    device.setMode(selectedMode);
	                    device.turnOff();
	                    break;

	                case 4:
	                    device = new Speaker();
	                    System.out.println("Select Speaker Mode:");
	                    System.out.println("1. Bass");
	                    System.out.println("2. Treble");

	                    int sChoice = sc.nextInt();
	                    selectedMode = (sChoice == 1) ? "Bass" : "Treble";
	                    device.turnOn();

	                   

	                    device.setMode(selectedMode);
	                    device.turnOff();
	                    break;

	                case 5:
	                    System.out.println("Exiting system...");
	                    break;

	                default:
	                    System.out.println("Invalid device choice!");
	            }

	        } while (choice != 5);

	        sc.close();
	    }

}
