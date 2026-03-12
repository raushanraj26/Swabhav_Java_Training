package com.monocept.Interface.Vehicle.test;

import java.util.Scanner;
import com.monocept.Interface.Vehicle.model.*;

public class VehicleTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleControl vehicle = null;

        while (true) {

            System.out.println("\n--- Vehicle Menu ---");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    vehicle = new Car();
                    break;

                case 2:
                    vehicle = new Bike();
                    break;

                case 3:
                    vehicle = new Truck();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            vehicle.start();

            System.out.print("Enter gear: ");
            int gear = sc.nextInt();

            vehicle.changeGear(gear);

            vehicle.stop();
        }
    }
}