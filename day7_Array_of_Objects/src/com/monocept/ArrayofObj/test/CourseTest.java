package com.monocept.ArrayofObj.test;

import com.monocept.ArrayofObj.model.Course;
import com.monocept.ArrayofObj.model.RegularCourse;
import com.monocept.ArrayofObj.model.OnlineCourse;

import java.util.Scanner;

public class CourseTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[10];
        int count = 0;
        int choice;

        do {
            System.out.println("\n---- Course Management System -----");
            System.out.println("1. Add Regular Course");
            System.out.println("2. Add Online Course");
            System.out.println("3. Display All Courses");
            System.out.println("4. Show Total Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    if (count >= courses.length) {
                        System.out.println("Course storage is full!");
                        break;
                    }

                    System.out.println("\n--- Add Regular Course ---");

                    System.out.print("Enter Course ID: ");
                    String rId = sc.nextLine();

                    System.out.print("Enter Course Name: ");
                    String rName = sc.nextLine();

                    double rFee;
                    do {
                        System.out.print("Enter Base Fee: ");
                        rFee = sc.nextDouble();

                        if (rFee < 0) {
                            System.out.println("Fee cannot be negative! Try again.");
                        }

                    } while (rFee < 0);

                    double labFee;
                    do {
                        System.out.print("Enter Lab Fee: ");
                        labFee = sc.nextDouble();

                        if (labFee < 0) {
                            System.out.println("Lab Fee cannot be negative! Try again.");
                        }

                    } while (labFee < 0);

                    sc.nextLine();

                    courses[count++] = new RegularCourse(rId, rName, rFee, labFee);
                    System.out.println("Regular Course Added Successfully!");
                    break;

                case 2:

                    if (count >= courses.length) {
                        System.out.println("Course storage is full!");
                        break;
                    }

                    System.out.println("\n--- Add Online Course ---");

                    System.out.print("Enter Course ID: ");
                    String oId = sc.nextLine();

                    System.out.print("Enter Course Name: ");
                    String oName = sc.nextLine();

                    double oFee;
                    do {
                        System.out.print("Enter Base Fee: ");
                        oFee = sc.nextDouble();

                        if (oFee < 0) {
                            System.out.println("Fee cannot be negative! Try again.");
                        }

                    } while (oFee < 0);

                    double platformFee;
                    do {
                        System.out.print("Enter Platform Fee: ");
                        platformFee = sc.nextDouble();

                        if (platformFee < 0) {
                            System.out.println("Platform Fee cannot be negative! Try again.");
                        }

                    } while (platformFee < 0);

                    sc.nextLine();

                    courses[count++] = new OnlineCourse(oId, oName, oFee, platformFee);
                    System.out.println("Online Course Added Successfully!");
                    break;

                case 3:

                    System.out.println("\n--- Course Details ---");

                    for (int i = 0; i < count; i++) {
                        System.out.println("Course " + (i + 1));
                        System.out.println("Course Name: " + courses[i].getcoursename());
                        System.out.println("Final Fee: " + courses[i].calculateFee());
                        System.out.println("------------------------");
                    }

                    break;

                case 4:
                    System.out.println("Total Courses Created: " + Course.getTotalCourses());
                    break;

                case 5:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}