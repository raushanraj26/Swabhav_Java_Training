package com.monocept.TransportRoute.test;
import com.monocept.TransportRoute.model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        TransportManager manager = new TransportManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n===== TRANSPORT SYSTEM =====");
                System.out.println("1. Add Passenger");
                System.out.println("2. Board Passenger");
                System.out.println("3. Display All");
                System.out.println("4. Display by Route");
                System.out.println("5. Sort by Route");
                System.out.println("6. Sort by Name");
                System.out.println("7. Remove by Route");
                System.out.println("8. Exit");
             

                int choice;

                try {
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.nextLine(); // clear buffer
                    continue; // restart loop
                }

                switch (choice) {

                    case 1:
                        try {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            if (id <= 0) throw new IllegalArgumentException("Invalid ID");

                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            if (name.trim().isEmpty())
                                throw new IllegalArgumentException("Name cannot be empty");

                            if (name.isEmpty()) {
                                throw new IllegalArgumentException("Name cannot be empty");
                            }

                            // Name should not contain digits
                            if (name.matches(".*\\d.*")) {
                                throw new IllegalArgumentException("Name cannot contain numbers");
                            }

                            System.out.print("Enter Route Number: ");
                            int route = sc.nextInt();
                            sc.nextLine();

                            if (route <= 0)
                                throw new IllegalArgumentException("Invalid route");

                            System.out.print("Type (1-Daily, 2-Tourist): ");
                            int type = sc.nextInt();
                            sc.nextLine();

                            Passenger p;

                            if (type == 1) {
                                p = new DailyPassenger(id, name, route);
                            } else if (type == 2) {
                                p = new TouristPassenger(id, name, route);
                            } else {
                                throw new IllegalArgumentException("Invalid type");
                            }

                            manager.addPassenger(p);

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type!");
                            sc.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        manager.boardPassenger();
                        break;

                    case 3:
                        manager.displayAll();
                        break;

                    case 4:
                        System.out.print("Enter Route: ");
                        int r = sc.nextInt();
                        manager.displayByRoute(r);
                        break;

                    case 5:
                        manager.sortByRoute();
                        break;

                    case 6:
                        manager.sortByName();
                        break;

                    case 7:
                        System.out.print("Enter Route to remove: ");
                        int rr = sc.nextInt();
                        manager.removeByRoute(rr);
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
