package com.monocept.FilterAssignments;
import java.util.*;

public class StringFilter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "", " ", "Stream", "Code");

        list.stream()
            .filter(str -> !str.trim().isEmpty())
            .forEach(System.out::println);
    }
}
