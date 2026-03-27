package com.monocept.toArrayAssignment;
import java.util.*;

public class ListToArray {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        String[] arr = list.toArray(new String[0]);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
