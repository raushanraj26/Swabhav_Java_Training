package com.monocept.CountAssignment;
import java.util.*;

public class CountWordsStartingWithA {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "grape", "apricot");

        long count = words.stream()
                .map(String::toUpperCase)
                .filter(w -> w.startsWith("A"))
                .count();

        System.out.println("Words starting with A: " + count);
    }
}