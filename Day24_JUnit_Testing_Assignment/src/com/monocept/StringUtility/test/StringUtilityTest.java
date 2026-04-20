package com.monocept.StringUtility.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.monocept.StringUtility.model.StringUtility;

public class StringUtilityTest {
	@Test
	void testIsEmptyNull() {
	    assertTrue(StringUtility.isEmpty(null));
	}

	@Test
	void testIsEmptyBlank() {
	    assertTrue(StringUtility.isEmpty(""));
	}

	@Test
	void testIsEmptyWhitespace() {
	    assertTrue(StringUtility.isEmpty("   "));
	}

	@Test
	void testIsEmptyNormal() {
	    assertFalse(StringUtility.isEmpty("hello"));
	}

	// -------- toUpperCase --------
	@Test
	void testUpperCaseNormal() {
	    assertEquals("HELLO", StringUtility.toUpperCase("hello"));
	}

	@Test
	void testUpperCaseMixed() {
	    assertEquals("HELLO", StringUtility.toUpperCase("HeLLo"));
	}

	@Test
	void testUpperCaseEmpty() {
	    assertEquals("", StringUtility.toUpperCase(""));
	}

	@Test
	void testUpperCaseNull() {
	    assertNull(StringUtility.toUpperCase(null));
	}

	// -------- getLength --------
	@Test
	void testLengthNormal() {
	    assertEquals(5, StringUtility.getLength("hello"));
	}

	@Test
	void testLengthEmpty() {
	    assertEquals(0, StringUtility.getLength(""));
	}

	@Test
	void testLengthWhitespace() {
	    assertEquals(3, StringUtility.getLength("   "));
	}

	@Test
	void testLengthNull() {
	    assertEquals(0, StringUtility.getLength(null));
	}
	
	

}
