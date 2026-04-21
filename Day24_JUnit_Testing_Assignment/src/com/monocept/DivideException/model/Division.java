package com.monocept.DivideException.model;

public class Division {
	public static int divide(int a, int b) {
	    if (b == 0) {
	        throw new ArithmeticException("Cannot divide by zero");
	    }
	    return a / b;
	}

}
