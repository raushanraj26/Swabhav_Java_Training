package com.monocept.HospitalStaffRecord.Test;

import java.util.Scanner;
import com.monocept.HospitalStaffRecord.model.*;
public class HospitalSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum staff records: ");
        int size = sc.nextInt();

        Staff[] staffList = new Staff[size];

        int count = 0;
        int choice;

        do {

            System.out.println("\n===== HOSPITAL STAFF MENU =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Nurse");
            System.out.println("3. View All Staff");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    if(count >= size) {
                        System.out.println("Staff list full");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Doctor ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();

                    System.out.print("Enter Consultation Fee: ");
                    double fee = sc.nextDouble();

                    staffList[count] =
                            new Doctor(id, name, dept, spec, fee);

                    count++;

                    System.out.println("Doctor added successfully");
                    break;

                case 2:

                    if(count >= size) {
                        System.out.println("Staff list full");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Nurse ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    dept = sc.nextLine();

                    System.out.print("Enter Experience Years: ");
                    int exp = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Shift: ");
                    String shift = sc.nextLine();

                    staffList[count] =
                            new Nurse(id, name, dept, exp, shift);

                    count++;

                    System.out.println("Nurse added successfully");
                    break;

                case 3:

                    if(count == 0) {
                        System.out.println("No staff records found");
                        break;
                    }

                    System.out.println("\n===== STAFF RECORDS =====");

                    for(int i = 0; i < count; i++) {

                        staffList[i].displayDetails();

                        System.out.println("----------------------");
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
