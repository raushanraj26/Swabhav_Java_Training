package com.monocept.LimitAssignment;
import java.util.*;

public class FirstThreeNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raushan", "Rahul", "Abc", "cde", "fgh");

        names.stream()
             .limit(3)
             .forEach(System.out::println);
    }
}