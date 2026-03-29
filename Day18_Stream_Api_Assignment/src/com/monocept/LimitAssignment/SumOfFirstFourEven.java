package com.monocept.LimitAssignment;
import java.util.*;

public class SumOfFirstFourEven {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10);

        int sum = numbers.stream()
                         .filter(n -> n % 2 == 0)
                         .limit(4)
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Sum: " + sum);
    }
}
