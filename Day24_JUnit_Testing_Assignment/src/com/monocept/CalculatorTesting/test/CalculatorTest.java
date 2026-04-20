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

}
