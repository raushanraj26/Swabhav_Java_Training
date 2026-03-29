package com.monocept.LimitAssignment;
import java.util.*;

public class LongestWords {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Programming", "Code", "Developer", "AI");

        words.stream()
             .sorted((a, b) -> b.length() - a.length())
             .limit(3)
             .forEach(System.out::println);
    }
}
