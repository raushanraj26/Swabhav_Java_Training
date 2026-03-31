package com.monocept.StudentResult.model;


public class Student {

    private int rollNo;
    private String name;
    private int standard;
    private double marks;
    private String section;

    public Student(int rollNo, String name, int standard, double marks, String section) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
        this.marks = marks;
        this.section = section;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getStandard() {
        return standard;
    }

    public double getMarks() {
        return marks;
    }

    public String getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "RollNo: " + rollNo +
                ", Name: " + name +
                ", Std: " + standard +
                ", Marks: " + marks +
                ", Section: " + section;
    }
}