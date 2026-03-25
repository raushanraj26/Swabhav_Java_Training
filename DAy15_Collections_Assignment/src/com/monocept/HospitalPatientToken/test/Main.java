package com.monocept.HospitalPatientToken.test;
import com.monocept.HospitalPatientToken.model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientManager manager = new PatientManager();

        while (true) {
            try {
                System.out.println("\n===== HOSPITAL SYSTEM =====");
                System.out.println("1. Add Patient");
                System.out.println("2. Process Patient");
                System.out.println("3. Display All Patients");
                System.out.println("4. Display by Department");
                System.out.println("5. Sort by Age");
                System.out.println("6. Remove Discharged Patients");
                System.out.println("7. Exit");
                

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

                            if (id <= 0) {
                                throw new IllegalArgumentException("ID must be positive");
                            }

                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            if (name.trim().isEmpty()) {
                                throw new IllegalArgumentException("Name cannot be empty");
                            }

                            System.out.print("Enter Age: ");
                            int age = sc.nextInt();
                            sc.nextLine();

                            if (age <= 0 || age > 120) {
                                throw new IllegalArgumentException("Invalid age");
                            }

                            System.out.print("Enter Type (1-General, 2-Emergency): ");
                            int type = sc.nextInt();
                            sc.nextLine();

                            Patient p;

                            if (type == 1) {
                                p = new GeneralPatient(id, name, age);
                            } else if (type == 2) {
                                p = new EmergencyPatient(id, name, age);
                            } else {
                                throw new IllegalArgumentException("Invalid patient type");
                            }

                            System.out.print("Enter Department: ");
                            String dept = sc.nextLine().trim().toUpperCase();
                            if (dept.trim().isEmpty()) {
                                throw new IllegalArgumentException("Department cannot be empty");
                            }

                            manager.addPatient(p, dept);

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type! Please enter correct data.");
                            sc.nextLine(); // clear wrong input
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        manager.processPatient();
                        break;

                    case 3:
                        manager.displayAll();
                        break;

                    case 4:
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine().trim().toUpperCase();
                        manager.displayByDepartment(dept);
                        break;

                    case 5:
                        manager.sortByAge();
                        break;

                    case 6:
                        manager.removeDischarged();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }
}
