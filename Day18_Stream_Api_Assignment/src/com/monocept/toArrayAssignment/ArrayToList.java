package com.monocept.toArrayAssignment;
import java.util.*;
import java.util.stream.*;

public class ArrayToList {
    public static void main(String[] args) {
        String[] arr = {"one", "two", "three"};

        List<String> list = Arrays.stream(arr)
                                  .collect(Collectors.toList());

        System.out.println(list);
    }
}
