package com.monocept.ArrayofObj.model;

public class Intern extends Employee{
	 private double stipend;

	    public Intern(int id, String name, double stipend) {
	        super(id, name);
	        setStipend(stipend);
	    }

	    public void setStipend(double stipend) {
	        if (stipend <= 0) {
	            throw new IllegalArgumentException("Stipend must be positive");
	        }
	        this.stipend = stipend;
	    }

	    @Override
	    public double calculateSalary() {
	        return stipend;
	    }

}
