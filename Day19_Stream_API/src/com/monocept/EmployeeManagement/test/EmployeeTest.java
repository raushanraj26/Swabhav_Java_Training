
package com.monocept.EmployeeManagement.test;

import java.util.*;
import com.monocept.EmployeeManagement.model.*;


public class EmployeeTest {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Active Employees");
            System.out.println("3. Employees Salary > 120");
            System.out.println("4. Count Employees Department-wise");
            System.out.println("5. Highest Paid Employee");
            System.out.println("6. Sort by Salary (Desc) and Print Names");
            System.out.println("7. Group Employees by Department");
            System.out.println("8. Average Salary by Department");
            System.out.println("9. Exit");

            int choice;

            // ✅ Input validation
            try {
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    EmployeeService.addEmployee(employees, sc);
                    break;

                case 2:
                    EmployeeService.showActiveEMployees(employees);
                    break;

                case 3:
                    EmployeeService.getEmployeesAboveSalary(employees);
                    break;

                case 4:
                    EmployeeService.countEMployeesDepartmentWise(employees);
                    break;

                case 5:
                    EmployeeService.findHighestPaidEmployee(employees);
                    break;

                case 6:
                    EmployeeService.sortBySalaryDescAndPrintNames(employees);
                    break;

                case 7:
                    EmployeeService.groupEmployeesByDepartment(employees);
                    break;

                case 8:
                    EmployeeService.averageSalaryByDepartment(employees);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}

