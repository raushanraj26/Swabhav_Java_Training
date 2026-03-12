package com.monocept.CourseEnrollment.test;

import java.util.Scanner;
import com.monocept.CourseEnrollment.model.*;
public class CourseEnrollmentTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[10];
        int count = 0;
        int choice;

        do {

            System.out.println("\n====== STUDENT SYSTEM MENU ======");
            System.out.println("1. Add Regular Student");
            System.out.println("2. Add Scholarship Student");
            System.out.println("3. View All Students");
            System.out.println("4. Calculate Fees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Course Fee: ");
                    double fee = sc.nextDouble();

                    System.out.print("Enter Attendance %: ");
                    double attendance = sc.nextDouble();

                    students[count++] =
                        new RegularStudent(id, name, course, fee, attendance);

                    System.out.println("Regular Student Added");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    course = sc.nextLine();

                    System.out.print("Enter Course Fee: ");
                    fee = sc.nextDouble();

                    System.out.print("Enter Scholarship Amount: ");
                    double scholarship = sc.nextDouble();

                    students[count++] =
                        new ScholarshipStudent(id, name, course, fee, scholarship);

                    System.out.println("Scholarship Student Added");
                    break;

                case 3:
                    System.out.println("\n--- Student List ---");

                    for(int i = 0; i < count; i++) {
                        students[i].displayProfile();
                        System.out.println("-------------------");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Fee Details ---");

                    for(int i = 0; i < count; i++) {
                        System.out.println(students[i].getName()
                                + " Payable Fee: "
                                + students[i].calculatePayableFee());
                    }
                    break;

                case 5:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }

        } while(choice != 5);

        sc.close();
    }
}