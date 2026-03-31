package com.monocept.PredicateAssignments;
import java.util.function.*;
public class practice1 {
	public static void main(String[] args) {
		Predicate<String> isStartsWithR=x->x.toLowerCase().startsWith("R");
		Predicate<String> isendWithN=x->x.toLowerCase().endsWith("N");
		Predicate<String> StartAndEnd=x->x.toLowerCase().endsWith("N");
		
		
	}

}
