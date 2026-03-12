package com.monocept.Inheritance.model;

public class FullTimeEmployee extends Employee {

	private double basic;
	private double hra;
	private double da;

	// constructor
	public FullTimeEmployee(String id, String naam, double basic, double hra, double da) {
		super(id, naam); // calling parent constructor,parent class me id and name initialised hai so
							// super ko call krke waha se initialise kiye
		this.basic = basic;
		this.hra = hra;
		this.da = da;
	}

	@Override
	public double calculateSalary() {
		return basic + hra + da;
	}
}
