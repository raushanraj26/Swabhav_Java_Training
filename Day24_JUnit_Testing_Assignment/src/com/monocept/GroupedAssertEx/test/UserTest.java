package com.monocept.GroupedAssertEx.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.monocept.GroupedAssertEx.model.User;

public class UserTest {
	 @Test
	    void testUserProperties() {

	        User user = new User("Raushan", 22, "ACTIVE");

	        assertAll("User Properties",
	            () -> assertEquals("Raushan", user.getName()),
	            () -> assertEquals(22, user.getAge()),
	            () -> assertEquals("ACTIVE", user.getStatus()),
	            ()->assertThrows(IllegalArgumentException.class, () -> {
		            new User(null, 22, "ACTIVE");
		        }),
	            ()->assertThrows(IllegalArgumentException.class, () -> {
		            new User("Raushan", -5, "ACTIVE");
		        })
	        );
	    }

//	    @Test
//	    void testNullNameException() {
//	        assertThrows(IllegalArgumentException.class, () -> {
//	            new User(null, 22, "ACTIVE");
//	        });
//	    }
//
//	    @Test
//	    void testInvalidAgeException() {
//	        assertThrows(IllegalArgumentException.class, () -> {
//	            new User("Raushan", -5, "ACTIVE");
//	        });
//	    }

}
