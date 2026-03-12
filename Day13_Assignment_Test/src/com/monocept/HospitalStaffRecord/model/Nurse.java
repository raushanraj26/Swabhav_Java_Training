package com.monocept.HospitalStaffRecord.model;

public class Nurse extends Staff {

    private int experienceYears;
    private String shift;

    public Nurse(int id, String name, String department,
                 int experienceYears, String shift) {

        super(id, name, department);

        this.experienceYears = experienceYears;
        this.shift = shift;
    }

    @Override
    public void displayDetails() {

        System.out.println("\n--- Nurse Record ---");

        super.displayCommonDetails();

        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Shift: " + shift);
    }
}