package com.monocept.VehicleRegistration.test;

import java.util.Scanner;
import com.monocept.VehicleRegistration.model.*;
public class VehicleSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter max vehicles: ");
        int size = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[size];

        int count = 0;
        int choice;

        do {

            System.out.println("\n==== VEHICLE MENU ====");
            System.out.println("1. Register Car");
            System.out.println("2. Register Bike");
            System.out.println("3. View Vehicles");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    if(count >= size) {
                        System.out.println("Vehicle list full");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Registration Number: ");
                    String reg = sc.nextLine();

                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();

                    System.out.print("Enter Base Charge: ");
                    double charge = sc.nextDouble();

                    System.out.print("Enter Number of Seats: ");
                    int seats = sc.nextInt();

                    vehicles[count] = new Car(reg, owner, charge, seats);
                    count++;

                    System.out.println("Car Registered Successfully");

                    break;

                case 2:

                    if(count >= size) {
                        System.out.println("Vehicle list full");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Registration Number: ");
                    reg = sc.nextLine();

                    System.out.print("Enter Owner Name: ");
                    owner = sc.nextLine();

                    System.out.print("Enter Base Charge: ");
                    charge = sc.nextDouble();

                    System.out.print("Is it a sports bike (true/false): ");
                    boolean sports = sc.nextBoolean();

                    vehicles[count] = new Bike(reg, owner, charge, sports);
                    count++;

                    System.out.println("Bike Registered Successfully");

                    break;

                case 3:

                    if(count == 0) {
                        System.out.println("No vehicles registered");
                        break;
                    }

                    System.out.println("\n=== VEHICLE RECORDS ===");

                    for(int i = 0; i < count; i++) {

                        vehicles[i].displayDetails();

                        System.out.println("------------------------");
                    }

                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 4);

        sc.close();
    }
}