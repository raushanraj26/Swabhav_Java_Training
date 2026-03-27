package com.monocept.toArrayAssignment;
import java.util.Arrays;

public class UpperCaseArray {
    public static void main(String[] args) {
        String[] arr = {"java", "stream", "api"};

        Arrays.stream(arr)
              .map(String::toUpperCase)
              .forEach(System.out::println);
    }
}