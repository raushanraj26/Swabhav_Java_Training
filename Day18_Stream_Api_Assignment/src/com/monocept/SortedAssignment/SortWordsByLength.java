package com.monocept.SortedAssignment;
import java.util.*;

public class SortWordsByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "kiwi", "banana", "fig");

        words.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
}
