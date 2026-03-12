package com.monocept.ArrayofObj.model;

public class PartTimeEmployee extends Employee {
	private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hoursWorked, double hourlyRate) {
        super(id, name);
        setHoursWorked(hoursWorked);
        setHourlyRate(hourlyRate);
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked <= 0) {
            throw new IllegalArgumentException("Hours worked must be positive");
        }
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate must be positive");
        }
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

}
