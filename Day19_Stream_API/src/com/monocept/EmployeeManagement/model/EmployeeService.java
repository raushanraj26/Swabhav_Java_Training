package com.monocept.EmployeeManagement.model;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public  class EmployeeService {
	
	
	public static void addEmployee(List<Employee> employees, Scanner sc) {

	    try {
	        System.out.print("Enter Employee ID: ");
	        String id = sc.nextLine();

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Department: ");
	        String dept = sc.nextLine();

	        System.out.print("Enter Salary: ");
	        double salary = sc.nextDouble();

	        System.out.print("Is Active (true/false): ");
	        boolean status = sc.nextBoolean();
	        sc.nextLine(); // clear buffer

	        employees.add(new Employee(id, name, dept, salary, status));

	        System.out.println("✅ Employee added successfully!");

	    } catch (InputMismatchException e) {
	        System.out.println("❌ Invalid input! Please try again.");
	        sc.nextLine(); // clear buffer
	    }
	}
	

	public static void showActiveEMployees(List<Employee> employees) {
		if (employees.isEmpty()) {
	        System.out.println(" No employees available!");
	        return;
	    }
		employees.stream()
		.filter(emp->emp.isActiveStatus()==true)
		.forEach(System.out::println);
	}
	
	public static void getEmployeesAboveSalary(List<Employee> employees) {
		if (employees.isEmpty()) {
	        System.out.println(" No employees available!");
	        return;
	    }

	    double threshold = 120; // fixed value (you can change)

	    employees.stream()
	            .filter(emp -> emp.getSalary() > threshold)
	            .forEach(System.out::println);
	}
	
	public static void countEMployeesDepartmentWise(List<Employee> employees) {
		if (employees.isEmpty()) {
	        System.out.println(" No employees available!");
	        return;
	    }

	    Map<String, Long> map = employees.stream()
	            .collect(Collectors.groupingBy(
	                    emp -> emp.getDepartment(),
	                    Collectors.counting()
	            ));

	    map.forEach((dept, count) ->
	            System.out.println(dept + " -> " + count)
	    );
	}
	
	public static void findHighestPaidEmployee(List<Employee> employees) {
		if (employees.isEmpty()) {
	        System.out.println("No employees available!");
	        return;
	    }
	    employees.stream()
	            .max(java.util.Comparator.comparing(emp -> emp.getSalary()))
	            .ifPresent(emp -> System.out.println("Highest Paid: " + emp));
	}
	public static void sortBySalaryDescAndPrintNames(List<Employee> employees) {
		if (employees.isEmpty()) {
	        System.out.println(" No employees available!");
	        return;
	    }

	    employees.stream()
	            .sorted(Comparator.comparing(Employee::getSalary).reversed())
	            .map(emp -> emp.getName())
	            .forEach(System.out::println);
	}
	
	public static void groupEmployeesByDepartment(List<Employee> employees) {
		if (employees.isEmpty()) {
	        System.out.println(" No employees available!");
	        return;
	    }

	    Map<String, List<Employee>> map = employees.stream()
	            .collect(Collectors.groupingBy(
	                    emp -> emp.getDepartment()
	            ));

	    map.forEach((dept, empList) -> {
	        System.out.println(dept + " -> " + empList);
	    });
	}
	public static void averageSalaryByDepartment(List<Employee> employees) {
		if (employees.isEmpty()) {
	        System.out.println("No employees available!");
	        return;
	    }

	    Map<String, Double> map = employees.stream()
	            .collect(java.util.stream.Collectors.groupingBy(
	                    emp -> emp.getDepartment(),
	                    java.util.stream.Collectors.averagingDouble(emp -> emp.getSalary())
	            ));

	    map.forEach((dept, avgSalary) ->
	            System.out.println(dept + " -> " + avgSalary)
	    );
	}
	

}
