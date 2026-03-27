package com.monocept.SortedAssignment;
import java.util.*;

class Student {
    int marks;
    String name;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class SortStudentsByMarks {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Raushan", 50),
                new Student("Raj", 30),
                new Student("Abscde", 70)
        );

        students.stream()
                .sorted(Comparator.comparingInt(s -> s.marks))
               // .sorted(Comparator.comparingInt(s -> s.marks).reversed())
                .forEach(s -> System.out.println(s.name + " - " + s.marks));
    }
}
