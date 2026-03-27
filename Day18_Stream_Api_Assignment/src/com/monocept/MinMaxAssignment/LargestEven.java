package com.monocept.MinMaxAssignment;
import java.util.*;

public class LargestEven {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 30, 21, 18, 7);

        int maxEven = numbers.stream()
                             .filter(n -> n % 2 == 0)
                             .max(Integer::compare)
                             .get();

        System.out.println("Largest even number: " + maxEven);
    }
}
