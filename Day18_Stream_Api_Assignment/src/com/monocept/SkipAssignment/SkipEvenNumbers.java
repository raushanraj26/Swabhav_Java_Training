package com.monocept.SkipAssignment;
import java.util.*;

public class SkipEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 8, 10);

        numbers.stream()
               .filter(n -> n % 2 == 0)
               .skip(2)
               .forEach(System.out::println);
    }
}