package com.monocept.ArrayofObj.test;
import java.util.Scanner;
import com.monocept.ArrayofObj.model.*;
public class PayrollTest {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[5];
        int count = 0;
        int choice;

        do {
            System.out.println("\n------ COMPANY PAYROLL SYSTEM ------");
            System.out.println("1. Add Full Time Employee");
            System.out.println("2. Add Part Time Employee");
            System.out.println("3. Add Intern");
            System.out.println("4. Display Payroll");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (count < employees.length) {

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Monthly Salary: ");
                        double salary = sc.nextDouble();

                        System.out.print("Enter Bonus: ");
                        double bonus = sc.nextDouble();

                        // Basic validation
                        if (name.trim().isEmpty()) {
                            System.out.println("Invalid Name!");
                        } 
                        else if (salary <= 0 || bonus < 0) {
                            System.out.println("Invalid Salary or Bonus!");
                        } 
                        else {
                            employees[count++] =
                                    new FullTimeEmployee(id, name, salary, bonus);
                            System.out.println("Full Time Employee Added Successfully!");
                        }

                    } else {
                        System.out.println("Employee array is full!");
                    }
                    break;

                case 2:
                    if (count < employees.length) {

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Hours Worked: ");
                        double hours = sc.nextDouble();

                        System.out.print("Enter Hourly Rate: ");
                        double rate = sc.nextDouble();

                        if (name.trim().isEmpty()) {
                            System.out.println("Invalid Name!");
                        } 
                        else if (hours <= 0 || rate <= 0) {
                            System.out.println("Invalid Hours or Rate!");
                        } 
                        else {
                            employees[count++] =
                                    new PartTimeEmployee(id, name, hours, rate);
                            System.out.println("Part Time Employee Added Successfully!");
                        }

                    } else {
                        System.out.println("Employee array is full!");
                    }
                    break;

                case 3:
                    if (count < employees.length) {

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Stipend: ");
                        double stipend = sc.nextDouble();

                        if (name.trim().isEmpty()) {
                            System.out.println("Invalid Name!");
                        } 
                        else if (stipend <= 0) {
                            System.out.println("Invalid Stipend!");
                        } 
                        else {
                            employees[count++] =
                                    new Intern(id, name, stipend);
                            System.out.println("Intern Added Successfully!");
                        }

                    } else {
                        System.out.println("Employee array is full!");
                    }
                    break;

                case 4:
                    System.out.println("\n------ PAYROLL DETAILS ------");

                    for (int i = 0; i < count; i++) {
                        employees[i].display();
                        System.out.println("Salary: " + employees[i].calculateSalary());
                        System.out.println("----------------------------");
                    }

                    System.out.println("Total Employees Created: "
                            + Employee.getEmployeeCount());
                    break;

                case 5:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
