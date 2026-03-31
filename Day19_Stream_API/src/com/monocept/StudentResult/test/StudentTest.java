package com.monocept.StudentResult.test;
import com.monocept.StudentResult.model.*;


import java.util.*;
import java.util.stream.Collectors;

public class StudentTest {

    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            printMenu();
            choice = getValidChoice();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    findPassedStudents();
                    break;

                case 3:
                    top3Students();
                    break;

                case 4:
                    groupBySection();
                    break;

                case 5:
                    countSectionWise();
                    break;

                case 6:
                    averageMarksBySection();
                    break;

                case 7:
                    namesInUppercase();
                    break;

                case 8:
                    checkFullMarks();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);
    }

    static void printMenu() {
        System.out.println("\n===== STUDENT RESULT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Find Passed Students");
        System.out.println("3. Top 3 Students");
        System.out.println("4. Group by Section");
        System.out.println("5. Count Section-wise");
        System.out.println("6. Average Marks by Section");
        System.out.println("7. Names in Uppercase");
        System.out.println("8. Check Full Marks");
        System.out.println("9. Exit");
        System.out.print("Enter choice: ");
    }

    // ---------------- VALIDATION METHODS ----------------

    static int getValidChoice() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter number: ");
            sc.next();
        }
        int choice = sc.nextInt();

        if (choice < 1 || choice > 9) {
            System.out.println("Choice must be between 1-9");
            return getValidChoice();
        }

        return choice;
    }

    static int getValidInt(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter integer: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static double getValidDouble(String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. Enter number: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    static String getValidString(String message) {
        System.out.print(message);
        String input = sc.next();
        if (input.trim().isEmpty()) {
            System.out.println("Input cannot be empty");
            return getValidString(message);
        }
        return input;
    }

    // ---------------- MENU OPERATIONS ----------------

    static void addStudent() {
        int roll = getValidInt("Enter Roll No: ");
        String name = getValidString("Enter Name: ");
        int std = getValidInt("Enter Standard: ");
        double marks = getValidDouble("Enter Marks: ");
        String section = getValidString("Enter Section: ");

        students.add(new Student(roll, name, std, marks, section));
        System.out.println("Student added successfully");
    }

    static void checkEmpty() {
        if (students.isEmpty()) {
            System.out.println("No students available");
            throw new RuntimeException();
        }
    }

    static void findPassedStudents() {
        try {
            checkEmpty();

            students.stream()
                    .filter(s -> s.getMarks() >= 40)
                    .forEach(System.out::println);

        } catch (Exception e) {
        }
    }

    static void top3Students() {
        try {
            checkEmpty();

            students.stream()
                    .sorted((a, b) -> Double.compare(b.getMarks(), a.getMarks()))
                    .limit(3)
                    .forEach(System.out::println);

        } catch (Exception e) {
        }
    }

    static void groupBySection() {
        try {
            checkEmpty();

            Map<String, List<Student>> map =
                    students.stream().collect(Collectors.groupingBy(Student::getSection));

            map.forEach((sec, list) -> {
                System.out.println("Section: " + sec);
                list.forEach(System.out::println);
            });

        } catch (Exception e) {
        }
    }

    static void countSectionWise() {
        try {
            checkEmpty();

            Map<String, Long> map =
                    students.stream()
                            .collect(Collectors.groupingBy(Student::getSection, Collectors.counting()));

            map.forEach((k, v) -> System.out.println(k + " -> " + v));

        } catch (Exception e) {
        }
    }

    static void averageMarksBySection() {
        try {
            checkEmpty();

            Map<String, Double> map =
                    students.stream()
                            .collect(Collectors.groupingBy(
                                    Student::getSection,
                                    Collectors.averagingDouble(Student::getMarks)
                            ));

            map.forEach((k, v) -> System.out.println(k + " -> " + v));

        } catch (Exception e) {
        }
    }

    static void namesInUppercase() {
        try {
            checkEmpty();

            students.stream()
                    .map(s -> s.getName().toUpperCase())
                    .forEach(System.out::println);

        } catch (Exception e) {
        }
    }

    static void checkFullMarks() {
        try {
            checkEmpty();

            boolean result =
                    students.stream()
                            .anyMatch(s -> s.getMarks() == 100);

            System.out.println(result ? "Full marks found" : "No full marks");

        } catch (Exception e) {
        }
    }
}