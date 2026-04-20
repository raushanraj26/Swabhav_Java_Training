package com.monocept.CalculatorTesting.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.monocept.CalculatorTesting.model.*;


public class CalculatorTest {
	@Test
    void testAddPositive() {
        assertEquals(10, Calculator.add(5, 5));
    }

    @Test
    void testAddNegative() {
        assertEquals(-10, Calculator.add(-5, -5));
    }

    @Test
    void testAddZero() {
        assertEquals(5, Calculator.add(5, 0));
    }

    @Test
    void testAddMixed() {
        assertEquals(0, Calculator.add(5, -5));
    }

    @Test
    void testAddNotEquals() {
        assertNotEquals(11, Calculator.add(5, 5));
    }
    
    @Test
    void testSubtractPositive() {
        assertEquals(2, Calculator.subtract(5, 3));
    }

    @Test
    void testSubtractNegative() {
        assertEquals(0, Calculator.subtract(-5, -5));
    }

    @Test
    void testSubtractZero() {
        assertEquals(5, Calculator.subtract(5, 0));
    }

    @Test
    void testSubtractMixed() {
        assertEquals(10, Calculator.subtract(5, -5));
    }

    @Test
    void testSubtractNotEquals() {
        assertNotEquals(1, Calculator.subtract(5, 3));
    }
    @Test
    void testMultiplyPositive() {
        assertEquals(25, Calculator.multiply(5, 5));
    }

    @Test
    void testMultiplyNegative() {
        assertEquals(25, Calculator.multiply(-5, -5));
    }

    @Test
    void testMultiplyZero() {
        assertEquals(0, Calculator.multiply(5, 0));
    }

    @Test
    void testMultiplyMixed() {
        assertEquals(-25, Calculator.multiply(5, -5));
    }

    @Test
    void testMultiplyNotEquals() {
        assertNotEquals(30, Calculator.multiply(5, 5));
    }
    @Test
    void testDividePositive() {
        assertEquals(2, Calculator.divide(10, 5));
    }

    @Test
    void testDivideNegative() {
        assertEquals(2, Calculator.divide(-10, -5));
    }

    @Test
    void testDivideMixed() {
        assertEquals(-2, Calculator.divide(10, -5));
    }

    @Test
    void testDivideNotEquals() {
        assertNotEquals(3, Calculator.divide(10, 5));
    }
    @Test
    void testDividebyZero() {
        assertEquals(0, Calculator.divide(10, 0));
    }
}
