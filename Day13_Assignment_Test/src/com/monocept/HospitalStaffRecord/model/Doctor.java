package com.monocept.HospitalStaffRecord.model;

public class Doctor extends Staff {

    private String specialization;
    private double consultationFee;

    public Doctor(int id, String name, String department,
                  String specialization, double consultationFee) {

        super(id, name, department);

        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    @Override
    public void displayDetails() {

        System.out.println("\n--- Doctor Record ---");

        super.displayCommonDetails();

        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: " + consultationFee);
    }
}