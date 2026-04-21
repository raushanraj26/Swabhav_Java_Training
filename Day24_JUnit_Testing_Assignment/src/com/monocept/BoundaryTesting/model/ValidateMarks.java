package com.monocept.BoundaryTesting.model;

public class ValidateMarks {
	public static boolean isValidMarks(int mark) {
		if (mark < 0) {
			throw new IllegalArgumentException("marks cannot be Negative!,may be 0");
		}
		if(mark>=0 && mark<=100) {
			return true;
		}else {
			return false;
		}
	}

}
