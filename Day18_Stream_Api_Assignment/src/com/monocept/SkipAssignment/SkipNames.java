package com.monocept.SkipAssignment;
import java.util.*;

public class SkipNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Abc", "Rahul", "Raj", "Raushan", "Raaz");

        names.stream()
             .skip(4)
             .forEach(System.out::println);
    }
}
