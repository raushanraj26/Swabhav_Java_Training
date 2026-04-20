package com.monocept.UserClass.test;

import org.junit.jupiter.api.BeforeEach;

import com.monocept.UserClass.model.User;

public class UserTest {
	
	
	//declare object
	User user;
	//runs before each test case->in this we are creating object
	//avoid creating object in every test,hence use beforeeach 
	@BeforeEach
	void setupObject() {
		user =new User();
		
	}
	

}
