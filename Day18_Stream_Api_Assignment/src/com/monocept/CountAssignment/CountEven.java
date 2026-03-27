package com.monocept.CountAssignment;
import java.util.*;

public class CountEven {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        long count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("Even numbers count: " + count);
    }
}