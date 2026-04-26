package com.monocept.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.App.util.DButil;

public class CourseDao {
	public void showCourses() {
	    String sql = "SELECT course_id, course_name FROM course";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        System.out.println("Available Courses:");
	        boolean found=false;
	        while (rs.next()) {
	        	found=true;
	            System.out.println(
	                rs.getInt("course_id") + " → " + rs.getString("course_name")
	            );
	        }
	        if(!found) {
	        	System.out.println("No courses Available!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
