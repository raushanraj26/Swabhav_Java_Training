package com.monocept.CountAssignment;
import java.util.*;

public class CountEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        long evenCount = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        long oddCount = numbers.stream()
                .filter(n -> n % 2 != 0)
                .count();

        System.out.println("Even count: " + evenCount);
        System.out.println("Odd count: " + oddCount);
    }
}