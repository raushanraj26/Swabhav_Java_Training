package com.monocept.SortedAssignment;
import java.util.*;

public class SortReverse {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Banana", "Apple", "Mango", "Cherry");

        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}