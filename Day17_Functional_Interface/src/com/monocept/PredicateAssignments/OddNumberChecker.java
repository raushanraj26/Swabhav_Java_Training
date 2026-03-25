package com.monocept.PredicateAssignments;

import java.util.function.Predicate;

public class OddNumberChecker {
//	Predicatee takes input and returns true/false
//	Method: test()
	public static void main(String[] args) {
    Predicate<Integer> isOdd = n -> n % 2 != 0;

  
    for(int i = 1; i <= 10; i++) {
        if(isOdd.test(i)) {
            System.out.println(i);
        }
    }
}
}

