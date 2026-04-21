package com.monocept.DivideException.test;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.monocept.DivideException.model.Division;

public class DivisionTest {
	@Test
	void shouldThrowExceptionWhenDividingByZero() {
	    assertThrows(ArithmeticException.class,() -> Division.divide(10, 0));
	}

}
