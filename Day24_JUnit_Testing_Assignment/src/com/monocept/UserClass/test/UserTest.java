package com.monocept.UserClass.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.monocept.UserClass.model.User;

public class UserTest {
	
	
	//declare object
	User user;
	//runs before each test case->in this we are creating object
	//avoid creating object in every test,hence use beforeeach 
	@BeforeEach
	void setupObject() {
		user =new User("Raushan", 21);
		
	}
	@AfterEach
	void UserNull() {
	    user = null;
	}
	
	@Test
	void testValidUser() {
	    assertEquals("Raushan", user.getName());
	    assertEquals(22, user.getAge());
	}
	
	@Test
	void testNullName() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new User(null, 22);
	    });
	}
	@Test
	void testInvalidAge() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new User("Raushan", -5);
	    });
	}
}
