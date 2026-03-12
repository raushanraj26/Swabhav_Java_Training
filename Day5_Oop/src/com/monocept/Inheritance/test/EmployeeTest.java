package com.monocept.Inheritance.test;

import java.util.Scanner;
import com.monocept.Inheritance.model.*;

public class EmployeeTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of employees: ");
		int n = sc.nextInt();
		sc.nextLine();

		Employee[] employees = new Employee[n];  // array of obj

		for (int i = 0; i < n; i++) {

			System.out.println("\nChoose Employee Type for "+(i+1) +" employee");
			System.out.println("1. Full Time");
			System.out.println("2. Part Time");
			System.out.println("3. Contract");

			int choice = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Employee ID: ");
			String id = sc.nextLine();

			System.out.print("Enter Employee Name: ");
			String name = sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter Basic Salary: ");
				double basic = sc.nextDouble();

				System.out.print("Enter HRA: ");
				double hra = sc.nextDouble();

				System.out.print("Enter DA: ");
				double da = sc.nextDouble();
				sc.nextLine();

				employees[i] = new FullTimeEmployee(id, name, basic, hra, da);
				break;

			case 2:
				System.out.print("Enter Hours Worked: ");
				double hours = sc.nextDouble();

				System.out.print("Enter Hourly Rate: ");
				double rate = sc.nextDouble();
				sc.nextLine();

				employees[i] = new PartTimeEmployee(id, name, hours, rate);
				break;

			case 3:
				System.out.print("Enter Fixed Amount: ");
				double fixed = sc.nextDouble();

				System.out.print("Enter Tax: ");
				double tax = sc.nextDouble();
				sc.nextLine();

				employees[i] = new ContractEmployee(id, name, fixed, tax);
				break;

			default:
				System.out.println("Invalid choice. Skipping employee.");
				i--;  // repeat same index
			}
		}

		System.out.println("\n------ PAYSLIPS ------");

		for (Employee emp : employees) {

			emp.displayEmployee();
			System.out.println("Salary: " + emp.calculateSalary());
			System.out.println("----------------------");
		}

		sc.close();
	}
}
