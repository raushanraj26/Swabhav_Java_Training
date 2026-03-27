package com.monocept.FunctionAssignmentQuestion;
import java.util.*;
import java.util.function.Function;

public class StudentGradeGenerator {

    public static void main(String[] args) {
        Function<Integer, String> gradeFunction = marks -> {
            if(marks >= 75) return "A";
            else if(marks >= 50) return "B";
            else return "Fail";
        };
        List<Integer> marksList = Arrays.asList(85, 60, 45, 90, 30);
        for(Integer marks : marksList) {
            System.out.println("Marks: " + marks + " -> Grade: " + gradeFunction.apply(marks));
        }
    }
}
