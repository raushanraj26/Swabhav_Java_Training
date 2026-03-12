package com.monocept.CourseEnrollment.model;

public abstract class Student {

    private int studentId;
    private String name;
    private String course;
    protected double courseFee;

    public Student(int studentId, String name, String course, double courseFee) {

        if(studentId <= 0)
            throw new IllegalArgumentException("Invalid ID");

        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Invalid Name");
        if(course == null || course.trim().isEmpty())
            throw new IllegalArgumentException("Invalid Course");

        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.courseFee = courseFee;
    }
public String getName() {
	return name;
}
    public void enrollCourse() {
        System.out.println(name + " enrolled in " + course);
    }

    public abstract double calculatePayableFee();

    public void displayProfile() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}