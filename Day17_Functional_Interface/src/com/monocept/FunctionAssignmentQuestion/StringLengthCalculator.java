package com.monocept.FunctionAssignmentQuestion;
import java.util.*;
import java.util.function.Function;

public class StringLengthCalculator {

    public static void main(String[] args) {
        Function<String, Integer> lengthFunction = s -> s.length();
        List<String> names = Arrays.asList("Java", "Spring", "Angular");
        for(String name : names) {
            System.out.println(name + " -> " + lengthFunction.apply(name));
        }
    }
}
