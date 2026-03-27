package com.monocept.MinMaxAssignment;
import java.util.*;

public class SmallestNumber {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 30, 2, 18);

        int min = numbers.stream()
                         .min(Integer::compare)
                         .get();

        System.out.println("Smallest number: " + min);
    }
}
