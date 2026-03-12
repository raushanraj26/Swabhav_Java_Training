package com.monocept.Inheritance.model;

public abstract class Employee {
	private final String empId;
	private final String name;
	
	//Constructor
	public  Employee(String id,String naam) {
		this.empId=id;
		this.name=naam;
	}
	
	//only declared,must be implemented by child class
    public abstract double calculateSalary();
    
    
    public void displayEmployee() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
    }
	

}
