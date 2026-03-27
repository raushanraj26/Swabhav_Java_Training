package com.monocept.MinMaxAssignment;
import java.util.*;

public class MaxLengthString {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java", "Programming", "AI", "Developer");

        String longest = words.stream()
                              .max(Comparator.comparingInt(String::length))
                              .get();

        System.out.println("Longest string: " + longest);
    }
}
