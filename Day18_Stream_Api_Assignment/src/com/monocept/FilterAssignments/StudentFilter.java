package com.monocept.FilterAssignments;

import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", 75),
            new Student("Rahul", 50),
            new Student("Neha", 65)
        );

        students.stream()
                .filter(s -> s.marks >= 60)
                .forEach(s -> System.out.println(s.name + " " + s.marks));
    }
}