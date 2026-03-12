package com.monocept.ArrayofObj.test;
import java.util.Scanner;
import com.monocept.ArrayofObj.model.*;
public class TollTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vehicle[] vehicles = new Vehicle[5];
        int count = 0;
        int choice;

        do {
            System.out.println("\n------ VEHICLE TOLL MANAGEMENT ------");
            System.out.println("1. Add Car");
            System.out.println("2. Add Truck");
            System.out.println("3. Add Motorcycle");
            System.out.println("4. Process & Display Toll");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    if (count < vehicles.length) {

                        System.out.print("Enter Vehicle Number: ");
                        String number = sc.nextLine();

                        if (number.trim().isEmpty()) {
                            System.out.println("Invalid Vehicle Number!");
                        } else {
                            vehicles[count++] = new Car(number);
                            System.out.println("Car Added Successfully!");
                        }

                    } else {
                        System.out.println("Vehicle array is full!");
                    }
                    break;

                case 2:
                    if (count < vehicles.length) {

                        System.out.print("Enter Vehicle Number: ");
                        String number = sc.nextLine();

                        System.out.print("Enter Truck Weight (in tons): ");
                        double weight = sc.nextDouble();
                        sc.nextLine();

                        if (number.trim().isEmpty()) {
                            System.out.println("Invalid Vehicle Number!");
                        } 
                        else if (weight <= 0) {
                            System.out.println("Weight must be positive!");
                        } 
                        else {
                            vehicles[count++] = new Truck(number, weight);
                            System.out.println("Truck Added Successfully!");
                        }

                    } else {
                        System.out.println("Vehicle array is full!");
                    }
                    break;

                case 3:
                    if (count < vehicles.length) {

                        System.out.print("Enter Vehicle Number: ");
                        String number = sc.nextLine();

                        if (number.trim().isEmpty()) {
                            System.out.println("Invalid Vehicle Number!");
                        } else {
                            vehicles[count++] = new Motorcycle(number);
                            System.out.println("Motorcycle Added Successfully!");
                        }

                    } else {
                        System.out.println("Vehicle array is full!");
                    }
                    break;

                case 4:
                    System.out.println("\n------ TOLL DETAILS ------");

                    for (int i = 0; i < count; i++) {

                        vehicles[i].display();

                        double toll = vehicles[i].calculateToll();  // Polymorphism
                        System.out.println("Toll: " + toll);
                        System.out.println("---------------------------");

                        Vehicle.addToll(toll);
                    }

                    System.out.println("Total Vehicles Processed: "
                            + Vehicle.getTotalVehiclesProcessed());

                    System.out.println("Total Toll Collected: "
                            + Vehicle.getTotalTollCollected());

                    break;

                case 5:
                    System.out.println("Exit...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
