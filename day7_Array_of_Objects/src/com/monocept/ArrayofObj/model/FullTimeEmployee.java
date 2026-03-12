package com.monocept.ArrayofObj.model;

public class FullTimeEmployee  extends Employee {
    private double monthlySalary;
    private double bonus;

    public FullTimeEmployee(int id, String name, double monthlySalary, double bonus) {
        super(id, name);   // constructor chaining
        setMonthlySalary(monthlySalary);
        setBonus(bonus);
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary <= 0) {
            throw new IllegalArgumentException("Monthly salary must be positive");
        }
        this.monthlySalary = monthlySalary;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus cannot be negative");
        }
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }
}
