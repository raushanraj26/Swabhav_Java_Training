package com.monocept.PasswordValidator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.monocept.PasswordValidator.model.PasswordValidator;

public class passwordValidator {
	@ParameterizedTest
    @CsvSource({
        "Password1, true",   // valid
        "Pass1, false",      // < 8 chars
        "password1, false",  // no uppercase
        "Password, false",   // no digit
        "'', false",         // empty
        "NULL, false"        // null
    })
	void shouldValidatePassword(String input, boolean expected) {

        if ("NULL".equals(input)) {
            input = null;
        }

        assertEquals(expected, PasswordValidator.isValidPassword(input));
    }
	
	@Test
	@Disabled
	void shouldReturnTrueForValidPassword() {
	    assertTrue(PasswordValidator.isValidPassword("Password1"));
	}

	@Test
	@Disabled
	void shouldReturnFalseWhenLengthIsLessThan8() {
	    assertFalse(PasswordValidator.isValidPassword("Pass1"));
	}

	@Test
	@Disabled
	void shouldReturnFalseWhenNoUppercase() {
	    assertFalse(PasswordValidator.isValidPassword("password1"));
	}

	@Test
	@Disabled
	void shouldReturnFalseWhenNoDigit() {
	    assertFalse(PasswordValidator.isValidPassword("Password"));
	}

	@Test
	@Disabled
	void shouldReturnFalseForNull() {
	    assertFalse(PasswordValidator.isValidPassword(null));
	}

	@Test
	@Disabled
	void shouldReturnFalseForEmpty() {
	    assertFalse(PasswordValidator.isValidPassword(""));
	}

}
