package com.monocept.SortedAssignment;
import java.util.*;

public class SortStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Banana", "Apple", "Mango", "Cherry");

        names.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
