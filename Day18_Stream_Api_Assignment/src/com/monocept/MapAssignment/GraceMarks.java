package com.monocept.MapAssignment;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class GraceMarks {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", 30),
            new Student("Neha", 40),
            new Student("Rahul", 20)
        );

        List<Student> updated = students.stream()
                .map(s -> {
                    if (s.marks < 35) {
                        s.marks += 5;
                    }
                    return s;
                })
                .collect(Collectors.toList());

        updated.forEach(s -> 
            System.out.println(s.name + " " + s.marks)
        );
    }
}
