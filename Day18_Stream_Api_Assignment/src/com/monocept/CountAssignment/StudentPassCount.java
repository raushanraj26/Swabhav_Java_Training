package com.monocept.CountAssignment;
import java.util.*;

class Student {
    int marks;

    Student(int marks) {
        this.marks = marks;
    }
}

public class StudentPassCount {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(30),
                new Student(50),
                new Student(70),
                new Student(20),
                new Student(40)
        );

        long count = students.stream()
                .filter(s -> s.marks >= 40)
                .count();

        System.out.println("Passed students: " + count);
    }
}