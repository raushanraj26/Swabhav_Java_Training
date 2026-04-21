package com.monocept.GroupedAssertEx.model;

public class User {
	 private String name;
	    private int age;
	    private String status;

	    public User(String name, int age, String status) {
	    	 if (name == null) {
	    	        throw new IllegalArgumentException("Name cannot be null");
	    	    }
	    	    if (age < 0) {
	    	        throw new IllegalArgumentException("Age cannot be negative");
	    	    }
	        this.name = name;
	        this.age = age;
	        this.status = status;
	    }

	    public String getName() {
	    	return name; 
	    	}
	    public int getAge() {
	    	return age; 
	    	}
	    public String getStatus() { 
	    	return status; 
	    	}

}
