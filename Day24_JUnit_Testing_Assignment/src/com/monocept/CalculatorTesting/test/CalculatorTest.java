package com.monocept.CalculatorTesting.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.monocept.CalculatorTesting.model.*;


public class CalculatorTest {
	
//	@Test
	@ParameterizedTest
	@CsvSource({
	    "5, 5, 10",
	    "-5, -5, -10",
	    "5, 0, 5",
	    "5, -5, 0"
	})
	void shouldReturnCorrectSum(int a, int b, int expected) {
	    assertEquals(expected, Calculator.add(a, b));
	}
	
	
	@ParameterizedTest
	@CsvSource({
	    "5, 3, 2",
	    "-5, -5, 0",
	    "5, 0, 5",
	    "5, -5, 10"
	})
	void shouldReturnCorrectDifference(int a, int b, int expected) {
	    assertEquals(expected, Calculator.subtract(a, b));
	}
	
	
	@ParameterizedTest
	@CsvSource({
	    "5, 5, 25",
	    "-5, -5, 25",
	    "5, 0, 0",
	    "5, -5, -25"
	})
	
	void shouldReturnCorrectProduct(int a, int b, int expected) {
	    assertEquals(expected, Calculator.multiply(a, b));
	}
	
	
	@ParameterizedTest
	@CsvSource({
	    "10, 5, 2",
	    "-10, -5, 2",
	    "10, -5, -2"
	})
	
	void shouldReturnCorrectQuotient(int a, int b, int expected) {
	    assertEquals(expected, Calculator.divide(a, b));
	}
	
	@Test
	void shouldThrowExceptionWhenDivideByZero() {
	  assertThrows(ArithmeticException.class,() -> Calculator.divide(10, 0));

	    
	}
	
	
//	@Test
//	@Disabled
//    void testAddPositive() {
//        assertEquals(10, Calculator.add(5, 5));
//    }
//
//    @Test
//    @Disabled
//    void testAddNegative() {
//        assertEquals(-10, Calculator.add(-5, -5));
//    }
//
//    @Test
//    @Disabled
//    void testAddZero() {
//        assertEquals(5, Calculator.add(5, 0));
//    }
//
//    @Test
//    @Disabled
//    void testAddMixed() {
//        assertEquals(0, Calculator.add(5, -5));
//    }
//
//    @Test
//    @Disabled
//    void testAddNotEquals() {
//        assertNotEquals(11, Calculator.add(5, 5));
//    }
//    
//    @Test
//    @Disabled
//    void testSubtractPositive() {
//        assertEquals(2, Calculator.subtract(5, 3));
//    }
//
//    @Test
//    @Disabled
//    void testSubtractNegative() {
//        assertEquals(0, Calculator.subtract(-5, -5));
//    }
//
//    @Test
//    @Disabled
//    void testSubtractZero() {
//        assertEquals(5, Calculator.subtract(5, 0));
//    }
//
//    @Test
//    @Disabled
//    void testSubtractMixed() {
//        assertEquals(10, Calculator.subtract(5, -5));
//    }
//
//    @Test
//    @Disabled
//    void testSubtractNotEquals() {
//        assertNotEquals(1, Calculator.subtract(5, 3));
//    }
//    @Test
//    @Disabled
//    void testMultiplyPositive() {
//        assertEquals(25, Calculator.multiply(5, 5));
//    }
//
//    @Test
//    @Disabled
//    void testMultiplyNegative() {
//        assertEquals(25, Calculator.multiply(-5, -5));
//    }
//
//    @Test
//    @Disabled
//    void testMultiplyZero() {
//        assertEquals(0, Calculator.multiply(5, 0));
//    }

//    @Test
//    void testMultiplyMixed() {
//        assertEquals(-25, Calculator.multiply(5, -5));
//    }
//
//    @Test
//    void testMultiplyNotEquals() {
//        assertNotEquals(30, Calculator.multiply(5, 5));
//    }
//    @Test
//    void testDividePositive() {
//        assertEquals(2, Calculator.divide(10, 5));
//    }
//
//    @Test
//    void testDivideNegative() {
//        assertEquals(2, Calculator.divide(-10, -5));
//    }
//
//    @Test
//    void testDivideMixed() {
//        assertEquals(-2, Calculator.divide(10, -5));
//    }
//
//    @Test
//    void testDivideNotEquals() {
//        assertNotEquals(3, Calculator.divide(10, 5));
//    }
//    @Test
//    void testDividebyZero() {
//        assertEquals(0, Calculator.divide(10, 0));
//    }
}
