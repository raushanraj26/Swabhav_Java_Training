package com.monocept.MinMaxAssignment;
import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + marks;
    }
}


public class HighestMarks {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1, "ABc", 85),
                new Student(2, "def", 92),
                new Student(3, "ghi", 88)
        );

        Student topper = students.stream()
                                 .max(Comparator.comparingInt(s -> s.marks))
                                 .get();

        System.out.println("Topper: " + topper);
    }
}
