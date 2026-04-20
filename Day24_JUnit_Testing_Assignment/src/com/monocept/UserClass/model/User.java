package com.monocept.UserClass.model;

public class User {
	private String name;
	private int age;
	
	public User(String name,int age) {
		 if (name == null) {
	            throw new IllegalArgumentException("Name cannot be null");
	        }
	        if (age < 0) {
	            throw new IllegalArgumentException("Age cannot be negative");
	        }
		this.name=name;
		this.age=age;
	}

}
