package com.studentcourse.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.Model.Course;
import com.studentcourse.util.DbConnection;

import java.sql.Connection;
public class CourseDAO {
//	1.add course
	public void addCourse(Course course) {

	    try {

	    	Connection con = DbConnection.getConnection();

	        String sql =
	        "INSERT INTO courses(course_name,duration,fees,trainer_name) VALUES(?,?,?,?)";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setString(1, course.getCourseName());

	        ps.setString(2, course.getDuration());

	        ps.setDouble(3, course.getFees());

	        ps.setString(4, course.getTrainerName());

	        ps.executeUpdate();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
	
//	2.Get all courses
	public List<Course> getAllCourses() {

	    List<Course> courseList =
	            new ArrayList<>();

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	                "SELECT * FROM courses";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ResultSet rs =
	                ps.executeQuery();

	        while(rs.next()) {

	            Course course =
	                    new Course();

	            course.setCourseId(
	                    rs.getInt("course_id"));

	            course.setCourseName(
	                    rs.getString("course_name"));

	            course.setDuration(
	                    rs.getString("duration"));

	            course.setFees(
	                    rs.getDouble("fees"));

	            course.setTrainerName(
	                    rs.getString("trainer_name"));

	            courseList.add(course);
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return courseList;
	}
	
//	3.Update course
	public void updateCourse(Course course) {

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	        "UPDATE courses SET course_name=?, duration=?, fees=?, trainer_name=? WHERE course_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setString(1, course.getCourseName());

	        ps.setString(2, course.getDuration());

	        ps.setDouble(3, course.getFees());

	        ps.setString(4, course.getTrainerName());

	        ps.setInt(5, course.getCourseId());

	        ps.executeUpdate();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
	
//	4.Delete course
	public void deleteCourse(int courseId) {

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	                "DELETE FROM courses WHERE course_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, courseId);

	        ps.executeUpdate();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
//	5.get course by id
	public Course getCourseById(int id) {

	    Course course = null;

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	            "SELECT * FROM courses WHERE course_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, id);

	        ResultSet rs =
	                ps.executeQuery();

	        if(rs.next()) {

	            course = new Course();

	            course.setCourseId(
	                    rs.getInt("course_id"));

	            course.setCourseName(
	                    rs.getString("course_name"));

	            course.setDuration(
	                    rs.getString("duration"));

	            course.setFees(
	                    rs.getDouble("fees"));

	            course.setTrainerName(
	                    rs.getString("trainer_name"));
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return course;
	}

}
