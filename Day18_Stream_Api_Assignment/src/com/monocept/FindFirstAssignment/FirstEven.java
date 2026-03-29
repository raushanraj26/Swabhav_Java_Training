package com.monocept.FindFirstAssignment;
import java.util.*;

public class FirstEven {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 9, 4, 6);

        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();

        firstEven.ifPresent(System.out::println);
    }
}
