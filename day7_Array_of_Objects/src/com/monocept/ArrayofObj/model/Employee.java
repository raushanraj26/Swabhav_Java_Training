package com.monocept.ArrayofObj.model;

public abstract class Employee {
	private int employeeId;
    private String name;

    private static int employeeCount = 0;

    // Constructor
    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        setName(name);   // validation
        employeeCount++;
    }

    // Name validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    // Abstract method (Polymorphism)
    public abstract double calculateSalary();

    // Method Overloading
    public double calculateSalary(double bonus) {
        return calculateSalary() + bonus;
    }

    public void display() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

}
