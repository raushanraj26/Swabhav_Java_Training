package com.monocept.SortedAssignment;
import java.util.*;

public class SortByLength {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Rahul", "Sanjay", "Al");

        names.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
}
