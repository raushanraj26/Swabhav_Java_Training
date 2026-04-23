package com.monocept.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.App.util.DButil;

public class RegistrationDao {
	// check duplication of course for a specific student
	public boolean checkAlreadyEnrollInSameCourse(int studentId, String course) {
		String sql = "SELECT * FROM registration WHERE student_id=? AND course_name=?";

		try {
			Connection connection = DButil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, studentId);
			ps.setString(2, course);

			ResultSet rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	register course
	public boolean registerCourse( int studentId, String course, double fee) {
		String sql = "INSERT INTO registration(student_id, course_name, fees_paid) VALUES (?, ?, ?)";

		try {
			Connection connection = DButil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, studentId);
			ps.setString(2, course);
			ps.setDouble(3, fee);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// update course fees take parameter as studentid,course name and updated fees
	public boolean updateFee(int studentId, String course, double fee) {
		String sql = "UPDATE registration SET fees_paid=? WHERE student_id=? AND course_name=?";

		try {
			Connection connection = DButil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, fee);
			ps.setInt(2, studentId);
			ps.setString(3, course);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//display all student with courses
	public void viewAllStudentsWithCourses() {
		String sql = "SELECT s.id, s.name, s.branch, r.course_name, r.fees_paid FROM student s LEFT JOIN registration r ON s.id = r.student_id";

		try {
			Connection con = DButil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			
			boolean found = false; 
			while (rs.next()) {
				found=true;
				System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("branch")
						+ " | " + rs.getString("course_name") + " | " + rs.getDouble("fees_paid"));
			}
			if (!found) {
			    System.out.println("No students found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Display full details of student by id
	public void getStudentFullDetailsbyId(int id) {
		String sql = "SELECT s.id, s.name,s.age, s.branch, r.course_name, r.fees_paid "
				+ "FROM student s LEFT JOIN registration r ON s.id = r.student_id " + "WHERE s.id=?";

		try {
			Connection con = DButil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			boolean found = false;

			while (rs.next()) {
				found = true;
				System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | "+ rs.getInt("age")+" | " + rs.getString("branch")
						+ " | " + rs.getString("course_name") + " | " + rs.getDouble("fees_paid"));
			}

			if (!found) {
				System.out.println("Student not found");}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// students who paying more than threshold
	public void highPayingStudents(double amount) {

		String sql = "SELECT s.name, r.course_name, r.fees_paid FROM student s JOIN registration r ON s.id = r.student_id WHERE r.fees_paid > ?";

		try {
			Connection con = DButil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, amount);
			ResultSet rs = ps.executeQuery();
boolean found=false;
			while (rs.next()) {
				found=true;
				System.out.println(
						rs.getString("name") + " | " + rs.getString("course_name") + " | " + rs.getDouble("fees_paid"));
			}
			if (!found) {
			    System.out.println("No students found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//course-wise student count
	public void courseWiseCount() {

	    String sql = "SELECT course_name, COUNT(*) AS total FROM registration GROUP BY course_name";

	    try {
	    	Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();
boolean found=false;
	        while (rs.next()) {
	        	found=true;
	            System.out.println(
	                rs.getString("course_name") + " -> " +
	                rs.getInt("total")
	            );
	        }
	        if (!found) {
			    System.out.println("No students found");
			}

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
