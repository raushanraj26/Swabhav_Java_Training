package com.monocept.EmployeeManagement.test;
import java.util.ArrayList;
import java.util.List;

import com.monocept.EmployeeManagement.model.*;
public class EmployeeTest {
	public static void main(String[] args) {
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee("1001","RAushan","CS",100,true));
		employees.add(new Employee("1001","Raushan","CSE",1001,false));
		employees.add(new Employee("100f","RAushan","CSS",120,true));
		employees.add(new Employee("101","RAushan","CSP",130,false));
		employees.add(new Employee("100f1","RAushan","CSD",140,true));
		
		employees.stream()
		.filter(emp->emp.isActiveStatus()==true)
		.forEach(System.out::println);
	}

}
