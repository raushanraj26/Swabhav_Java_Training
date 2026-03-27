package com.monocept.SkipAssignment;
import java.util.*;

public class SkipWords {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "apple", "dog", "banana", "car", "elephant");

        words.stream()
             .filter(w -> w.length() > 3)
             .skip(3)
             .forEach(System.out::println);
    }
}
