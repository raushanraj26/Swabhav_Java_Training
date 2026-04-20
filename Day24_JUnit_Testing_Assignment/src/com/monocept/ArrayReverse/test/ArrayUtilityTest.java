package com.monocept.ArrayReverse.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.monocept.ArrayReverse.model.ArrayUtility;

public class ArrayUtilityTest {
	// -------- Normal Array --------
    @Test
    void testReverseNormalArray() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};

        assertArrayEquals(expected, ArrayUtility.reverseArray(input));
    }

    // -------- Single Element --------
    @Test
    void testReverseSingleElement() {
        int[] input = {5};
        int[] expected = {5};

        assertArrayEquals(expected, ArrayUtility.reverseArray(input));
    }

    // -------- Empty Array --------
    @Test
    void testReverseEmptyArray() {
        int[] input = {};
        int[] expected = {};

        assertArrayEquals(expected, ArrayUtility.reverseArray(input));
    }

    // -------- Null Case --------
    @Test
    void testReverseNullArray() {
        assertNull(ArrayUtility.reverseArray(null));
    }

}
