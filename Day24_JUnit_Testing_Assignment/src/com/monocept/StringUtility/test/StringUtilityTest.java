package com.monocept.StringUtility.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.monocept.StringUtility.model.StringUtility;

public class StringUtilityTest {
	
	@ParameterizedTest
	@CsvSource({
	    "NULL, true",
	    "'', true",
	    "'   ', true",
	    "hello, false"
	})
	
	void shouldCheckIsEmpty(String input, boolean expected) {
		if ("NULL".equals(input)) {
	        input = null;
	    }
	    assertEquals(expected, StringUtility.isEmpty(input));
	}
	
	
	@ParameterizedTest
	@CsvSource({
	    "hello, HELLO",
	    "HeLLo, HELLO",
	    "'', ''",
	    "NULL, NULL"
	})
	void shouldConvertToUpperCase(String input, String expected) {

	    if ("NULL".equals(input)) input = null;
	    if ("NULL".equals(expected)) expected = null;

	    String result = StringUtility.toUpperCase(input);

    if (expected == null) {
        assertNull(result);
	    } else {
        assertEquals(expected, result);
	    }
		
//		 assertEquals(expected, StringUtility.isEmpty(input));
	}
	
	@ParameterizedTest
	@CsvSource({
	    "hello, 5",
	    "'', 0",
	    "'   ', 0",
	    "NULL, 0"
	})
	void shouldReturnCorrectLength(String input, int expected) {

	    if ("NULL".equals(input)) {
	        input = null;
	    }

	    assertEquals(expected, StringUtility.getLength(input));
	}
	
//	@Test
//	void testIsEmptyNull() {
//	    assertTrue(StringUtility.isEmpty(null));
//	}
//
//	@Test
//	void testIsEmptyBlank() {
//	    assertTrue(StringUtility.isEmpty(""));
//	}
//
//	@Test
//	void testIsEmptyWhitespace() {
//	    assertTrue(StringUtility.isEmpty("   "));
//	}
//
//	@Test
//	void testIsEmptyNormal() {
//	    assertFalse(StringUtility.isEmpty("hello"));
//	}

	
//	@Test
//	void testUpperCaseNormal() {
//	    assertEquals("HELLO", StringUtility.toUpperCase("hello"));
//	}
//
//	@Test
//	void testUpperCaseMixed() {
//	    assertEquals("HELLO", StringUtility.toUpperCase("HeLLo"));
//	}
//
//	@Test
//	void testUpperCaseEmpty() {
//	    assertEquals("", StringUtility.toUpperCase(""));
//	}
//
//	@Test
//	void testUpperCaseNull() {
//	    assertNull(StringUtility.toUpperCase(null));
//	}

	
//	@Test
//	void testLengthNormal() {
//	    assertEquals(5, StringUtility.getLength("hello"));
//	}
//
//	@Test
//	void testLengthEmpty() {
//	    assertEquals(0, StringUtility.getLength(""));
//	}
//
//	@Test
//	void testLengthWhitespace() {
//	    assertEquals(0, StringUtility.getLength("   "));
//	}
//
//	@Test
//	void testLengthNull() {
//	    assertEquals(0, StringUtility.getLength(null));
//	}
	
	

}
