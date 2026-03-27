package com.monocept.MapAssignment;
import java.util.*;

public class UppercaseExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "stream", "api");

        list.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}