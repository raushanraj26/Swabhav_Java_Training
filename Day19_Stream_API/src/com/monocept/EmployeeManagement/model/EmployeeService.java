package com.monocept.EmployeeManagement.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public  class EmployeeService {
	public static void showActiveEMployees(List<Employee> employees) {
		employees.stream()
		.filter(emp->emp.isActiveStatus()==true)
		.forEach(System.out::println);
	}
	
	public static void getEmployeesAboveSalary(List<Employee> employees) {

	    double threshold = 120; // fixed value (you can change)

	    employees.stream()
	            .filter(emp -> emp.getSalary() > threshold)
	            .forEach(System.out::println);
	}
	
	public static void countEMployeesDepartmentWise(List<Employee> employees) {

	    Map<String, Long> map = employees.stream()
	            .collect(Collectors.groupingBy(
	                    emp -> emp.getDepartment(),
	                    Collectors.counting()
	            ));

	    map.forEach((dept, count) ->
	            System.out.println(dept + " -> " + count)
	    );
	}
	
	

}
