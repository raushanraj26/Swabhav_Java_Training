package com.monocept.SkipAssignment;
import java.util.*;

public class SkipTopSalaries {
    public static void main(String[] args) {
        List<Integer> salaries = Arrays.asList(30000, 50000, 20000, 80000, 60000);

        salaries.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .forEach(System.out::println);
    }
}
