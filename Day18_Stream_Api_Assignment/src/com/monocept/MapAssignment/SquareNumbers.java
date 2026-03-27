package com.monocept.MapAssignment;
import java.util.*;
import java.util.stream.Collectors;

public class SquareNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 5);

        List<Integer> result = list.stream()
                                  .map(n -> n * n)
                                  .collect(Collectors.toList());

        System.out.println(result);
    }
}