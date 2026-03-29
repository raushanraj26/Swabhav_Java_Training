package com.monocept.FindFirstAssignment;
import java.util.*;

public class FirstName {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul", "Amit", "Neha");

        Optional<String> first = names.stream().findFirst();

        first.ifPresent(System.out::println);
    }
}