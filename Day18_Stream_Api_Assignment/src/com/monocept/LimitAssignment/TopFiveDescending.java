package com.monocept.LimitAssignment;
import java.util.*;

public class TopFiveDescending {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 50, 30, 90, 20, 70, 60);

        numbers.stream()
               .sorted(Comparator.reverseOrder())
               .limit(5)
               .forEach(System.out::println);
    }
}
