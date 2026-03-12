package com.monocept.Inheritance.model;

public class ContractEmployee extends Employee {

	private double fixedAmount;
	private double tax;

	public ContractEmployee(String id, String name,
	                        double fixedAmount, double tax) {
		super(id, name);   // call parent constructor
		this.fixedAmount = fixedAmount;
		this.tax = tax;
	}

	@Override
	public double calculateSalary() {
		return fixedAmount - tax;
	}
}
