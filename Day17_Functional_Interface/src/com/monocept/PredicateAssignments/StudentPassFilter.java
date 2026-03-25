package com.monocept.PredicateAssignments;

import java.util.*;
import java.util.function.Predicate;


class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}
public class StudentPassFilter {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Amit", 35),
            new Student("Rahul", 50),
            new Student("Neha", 80),
            new Student("Priya", 20),
            new Student("Karan", 60)
        );

        // Predicate
        Predicate<Student> isPass = s -> s.getMarks() >= 40;

        // Apply
        students.forEach(s -> {
            if(isPass.test(s)) {
                System.out.println(s.getName() + " - " + s.getMarks());
            }
        });
    }
}
