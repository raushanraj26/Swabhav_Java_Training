package com.monocept.ArrayofObj.model;

public abstract class Course {
	protected String courseId;
    protected String courseName;
    protected double baseFee;

    protected static int totalCourses;


    public Course(String id, String name, double fee) {
        this.courseId = id;
        this.courseName = name;
        this.baseFee = fee;
        totalCourses++;
    }
    
    //implement in child class,and it override and give only normal fee
    public abstract double calculateFee();

    //return fee after discount
    public double calculateFee(double discount) {
        return calculateFee() - discount;
    }

    public static int getTotalCourses() {
        return totalCourses;
    }

    public String  getcoursename() {
        return courseName;
    }


}
