package com.monocept.MapAssignment;
import java.util.*;

public class PrefixNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Neha", "Rahul");

        names.stream()
             .map(name -> "Mr./Ms. " + name)
             .forEach(System.out::println);
    }
}
