package com.monocept.CourseEnrollment.model;

public class ScholarshipStudent extends Student {

    private double scholarshipAmount;

    public ScholarshipStudent(int id, String name, String course, double fee, double scholarshipAmount) {
        super(id, name, course, fee);

        if(scholarshipAmount < 0)
            throw new IllegalArgumentException("Invalid scholarship");

        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public double calculatePayableFee() {
        return courseFee - scholarshipAmount;
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Scholarship: " + scholarshipAmount);
    }
}
