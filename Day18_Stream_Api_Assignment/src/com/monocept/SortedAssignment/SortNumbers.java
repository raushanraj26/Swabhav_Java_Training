package com.monocept.SortedAssignment;
import java.util.*;

public class SortNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3);

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
