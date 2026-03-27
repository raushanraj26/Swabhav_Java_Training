package com.monocept.CountAssignment;
import java.util.*;

public class CountPassedStudents {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(35, 50, 80, 20, 90, 40);

        long count = marks.stream()
                .filter(m -> m >= 40)
                .count();

        System.out.println("Number of passed students: " + count);
    }
}