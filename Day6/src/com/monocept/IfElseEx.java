package com.monocept;

import java.util.Scanner;

public class IfElseEx {

    static String getGrade(int marks) {

        if (marks >= 90) {
            return "A";
        } 
        else if (marks >= 75) {
            return "B";
        } 
        else if (marks >= 60) {
            return "C";
        } 
        else {
            return "Fail";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        System.out.println("Grade: " + getGrade(marks));

        sc.close();
    }
}
