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

public class PassedStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", 35),
            new Student("Rahul", 45),
            new Student("Neha", 80)
        );

        students.stream()
                .filter(s -> s.marks >= 40)
                .forEach(s -> System.out.println(s.name + " Passed"));
    }
}
