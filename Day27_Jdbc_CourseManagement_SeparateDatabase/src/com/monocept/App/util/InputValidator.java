package com.monocept.App.util;

public class InputValidator {

    // Validate ID
    public static String validateId(int id) {
        if (id <= 0) {
            return "ID must be a positive number.";
        }
        return null;
    }

    // Validate Name
    public static String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Name cannot be empty.";
        }
        if (!name.matches("[a-zA-Z ]+")) {
            return "Name should contain only letters.";
        }
        return null;
    }

    // Validate Age
    public static String validateAge(int age) {
        if (age < 18 || age > 60) {
            return "Age must be between 18 and 60.";
        }
        return null;
    }

    // Validate Fee
    public static String validateFee(double fee) {
        if (fee <= 0) {
            return "Fee must be greater than 0.";
        }
        return null;
    }

    // Validate Branch ID
    public static String validateBranchId(int branchId) {
        if (branchId <= 0) {
            return "Invalid Branch ID.";
        }
        return null;
    }

    // Validate Course ID
    public static String validateCourseId(int courseId) {
        if (courseId <= 0) {
            return "Invalid Course ID.";
        }
        return null;
    }

    // Validate Course Name 
    public static String validateCourseName(String course) {
        if (course == null || course.trim().isEmpty()) {
            return "Course name cannot be empty.";
        }
        return null;
    }
}
