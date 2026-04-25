package com.monocept.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseDao {
	public void showCourses() {
	    String sql = "SELECT course_id, course_name FROM course";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        System.out.println("Available Courses:");
	        while (rs.next()) {
	            System.out.println(
	                rs.getInt("course_id") + " → " + rs.getString("course_name")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
