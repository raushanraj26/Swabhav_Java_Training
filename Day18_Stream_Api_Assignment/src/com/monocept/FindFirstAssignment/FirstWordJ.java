package com.monocept.FindFirstAssignment;
import java.util.*;

public class FirstWordJ {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Java", "Python", "JavaScript");

        Optional<String> result = words.stream()
                .filter(w -> w.startsWith("J"))
                .findFirst();

        result.ifPresent(System.out::println);
    }
}
