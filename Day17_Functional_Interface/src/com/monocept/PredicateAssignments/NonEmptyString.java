package com.monocept.PredicateAssignments;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NonEmptyString {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("", "Java", null, " ");     
        Predicate<String> isValid = s -> s != null && !s.isEmpty();
        list.forEach(s -> {
            if(isValid.test(s)) {
                System.out.println(s);
            }
        });
    }
}