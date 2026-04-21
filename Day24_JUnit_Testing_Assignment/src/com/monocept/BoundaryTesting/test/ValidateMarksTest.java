package com.monocept.BoundaryTesting.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.monocept.BoundaryTesting.model.*;

public class ValidateMarksTest {
	@ParameterizedTest
	@CsvSource({
	    "0, true",
	    "1, true",
	    "99, true",
	    "100, true",
	    "-1, false",
	    "101, false"
	})
	void shouldValidateMarks(int marks, boolean expected) {
	    assertEquals(expected,ValidateMarks.isValidMarks(marks));
	}

}
