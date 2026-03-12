package com.monocept.HospitalStaffRecord.model;


	public abstract class Staff {

	    private int id;
	    private String name;
	    private String department;

	    public Staff(int id, String name, String department) {

	        if(id <= 0)
	            throw new IllegalArgumentException("Invalid ID");

	        if(name == null || name.trim().isEmpty())
	            throw new IllegalArgumentException("Invalid name");

	        if(department == null || department.trim().isEmpty())
	            throw new IllegalArgumentException("Invalid department");

	        this.id = id;
	        this.name = name;
	        this.department = department;
	    }

	    public void displayCommonDetails() {
	        System.out.println("ID: " + id);
	        System.out.println("Name: " + name);
	        System.out.println("Department: " + department);
	    }

	    public abstract void displayDetails();
	}

