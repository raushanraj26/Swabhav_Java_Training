 
package com.monocept.Inheritance.model;

public class PartTimeEmployee extends Employee {
	private double hoursWorked;
	private double hourlyRate;

	public PartTimeEmployee (String id, String name,
	                        double hoursWorked, double hourlyRate) {
		super(id, name);  // call parent constructor
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}

}
