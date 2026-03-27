package com.monocept.FilterAssignments;

import java.util.*;

public class NamesFilter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Rahul", "Ankit", "John");

        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);
    }
}