package com.monocept.HospitalManagement.test;


import com.monocept.HospitalManagement.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class PatientTest {

    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {

        int choice = -1;

        do {
            try {
                System.out.println("\n===== HOSPITAL PATIENT ANALYZER =====");
                System.out.println("1. Add Patient");
                System.out.println("2. Show Admitted Patients");
                System.out.println("3. Group by Disease");
                System.out.println("4. Count Admitted vs Non-Admitted");
                System.out.println("5. Highest Bill Patient");
                System.out.println("6. Average Bill Amount");
                System.out.println("7. Patients Age > 60");
                System.out.println("8. Disease -> Patient Names Map");
                System.out.println("9. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        addPatient();
                        break;

                    case 2:
                        showAdmittedPatients();
                        break;

                    case 3:
                        groupByDisease();
                        break;

                    case 4:
                        countAdmitted();
                        break;

                    case 5:
                        highestBill();
                        break;

                    case 6:
                        averageBill();
                        break;

                    case 7:
                        patientsAbove60();
                        break;

                    case 8:
                        diseaseToNamesMap();
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.nextLine(); // clear buffer
            }

        } while (choice != 9);
    }

    // methods

    static void addPatient() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            System.out.print("Admitted (true/false): ");
            boolean admitted = sc.nextBoolean();

            System.out.print("Enter Bill Amount: ");
            double bill = sc.nextDouble();

            patients.add(new Patient(id, name, age, disease, admitted, bill));
            System.out.println("Patient added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input! Patient not added.");
            sc.nextLine();
        }
    }

    static boolean isEmptyCheck() {
        if (patients.isEmpty()) {
            System.out.println("No patient data available!");
            return true;
        }
        return false;
    }

    static void showAdmittedPatients() {
        if (isEmptyCheck()) return;

        patients.stream()
                .filter(Patient::isAdmitted)
                .forEach(System.out::println);
    }

    static void groupByDisease() {
        if (isEmptyCheck()) return;

        Map<String, List<Patient>> map =
                patients.stream()
                        .collect(Collectors.groupingBy(Patient::getDisease));

        map.forEach((disease, list) -> {
            System.out.println(disease + " -> " + list);
        });
    }

    static void countAdmitted() {
        if (isEmptyCheck()) return;

        Map<Boolean, Long> result =
                patients.stream()
                        .collect(Collectors.partitioningBy(
                                Patient::isAdmitted,
                                Collectors.counting()
                        ));

        System.out.println("Admitted: " + result.get(true));
        System.out.println("Not Admitted: " + result.get(false));
    }

    static void highestBill() {
        if (isEmptyCheck()) return;

        patients.stream()
                .max(Comparator.comparingDouble(Patient::getBillAmount))
                .ifPresent(System.out::println);
    }

    static void averageBill() {
        if (isEmptyCheck()) return;

        double avg =
                patients.stream()
                        .collect(Collectors.averagingDouble(Patient::getBillAmount));

        System.out.println("Average Bill: " + avg);
    }

    static void patientsAbove60() {
        if (isEmptyCheck()) return;

        patients.stream()
                .filter(p -> p.getAge() > 60)
                .map(Patient::getName)
                .forEach(System.out::println);
    }

    static void diseaseToNamesMap() {
        if (isEmptyCheck()) return;

        Map<String, List<String>> map =
                patients.stream()
                        .collect(Collectors.groupingBy(
                                Patient::getDisease,
                                Collectors.mapping(Patient::getName, Collectors.toList())
                        ));

        map.forEach((disease, names) -> {
            System.out.println(disease + " -> " + names);
        });
    }
}