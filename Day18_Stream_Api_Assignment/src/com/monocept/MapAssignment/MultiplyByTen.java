package com.monocept.MapAssignment;
import java.util.*;
import java.util.stream.Collectors;

public class MultiplyByTen {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        List<Integer> result = list.stream()
                                  .map(n -> n * 10)
                                  .collect(Collectors.toList());

        System.out.println(result);
    }
}
