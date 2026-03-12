package com.monocept.CourseEnrollment.model;

public class RegularStudent extends Student {

    private double attendance;

    public RegularStudent(int id, String name, String course, double fee, double attendance) {
        super(id, name, course, fee);

        if(attendance < 0 || attendance > 100)
            throw new IllegalArgumentException("Invalid attendance");

        this.attendance = attendance;
    }

    @Override
    public double calculatePayableFee() {
        return courseFee;
    }

    public boolean canAppearForExam() {
        return attendance >= 75;
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Attendance: " + attendance);
    }
}
