package com.monocept.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.App.util.DButil;

public class RegistrationDao {
	// check duplication of course for a specific student
	public boolean checkAlreadyEnrollInSameCourse(int studentId, int courseid) {
		String sql = "SELECT * FROM registration WHERE student_id=? AND course_id=?";

		try {
			Connection connection = DButil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, studentId);
			ps.setInt(2, courseid);

			ResultSet rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	register course
	public boolean registerCourse(int studentId, int courseid, double fee) {
		String sql = "INSERT INTO registration(student_id, course_id, fees_paid) VALUES (?, ?, ?)";

		try {
			Connection connection = DButil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, studentId);
			ps.setInt(2, courseid);
			ps.setDouble(3, fee);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// update course fees take parameter as studentid,course name and updated fees
	public boolean updateFee(int studentId, int courseid, double fee) {
		String sql = "UPDATE registration SET fees_paid=? WHERE student_id=? AND course_id=?";

		try {
			Connection connection = DButil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, fee);
			ps.setInt(2, studentId);
			ps.setInt(3, courseid);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//display all student with courses
	public void viewAllStudentsWithCourses() {

	    String sql = "SELECT s.id, s.name, b.branch_name, c.course_name, r.fees_paid FROM student s"
	    		+ " JOIN branch b ON s.branch_id = b.branch_id"
	    		+ " LEFT JOIN registration r ON s.id = r.student_id "
	    		+ "LEFT JOIN course c ON r.course_id = c.course_id";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        boolean found = false;

	        while (rs.next()) {
	            found = true;

	            System.out.println(
	                rs.getInt("id") + " | " +
	                rs.getString("name") + " | " +
	                rs.getString("branch_name") + " | " +
	                (rs.getString("course_name") != null ? rs.getString("course_name") : "No Course") + " | " +
	                rs.getDouble("fees_paid")
	            );
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

	    String sql = "SELECT s.id, s.name, s.age, b.branch_name, c.course_name, r.fees_paid " +
	                 "FROM student s " +
	                 "JOIN branch b ON s.branch_id = b.branch_id " +
	                 "LEFT JOIN registration r ON s.id = r.student_id " +
	                 "LEFT JOIN course c ON r.course_id = c.course_id " +
	                 "WHERE s.id = ?";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        boolean found = false;

	        while (rs.next()) {
	            found = true;

	            System.out.println(
	                rs.getInt("id") + " | " +
	                rs.getString("name") + " | " +
	                rs.getInt("age") + " | " +
	                rs.getString("branch_name") + " | " +
	                (rs.getString("course_name") != null ? rs.getString("course_name") : "No Course") + " | " +
	                rs.getDouble("fees_paid")
	            );
	        }

	        if (!found) {
	            System.out.println("Student not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// students who paying more than threshold
	public void highPayingStudents(double amount) {

	    String sql = "SELECT s.name, c.course_name, r.fees_paid " +
	                 "FROM student s " +
	                 "JOIN registration r ON s.id = r.student_id " +
	                 "JOIN course c ON r.course_id = c.course_id " +
	                 "WHERE r.fees_paid > ?";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setDouble(1, amount);
	        ResultSet rs = ps.executeQuery();

	        boolean found = false;

	        while (rs.next()) {
	            found = true;

	            System.out.println(
	                rs.getString("name") + " | " +
	                rs.getString("course_name") + " | " +
	                rs.getDouble("fees_paid")
	            );
	        }

	        if (!found) {
	            System.out.println("No students found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// course-wise student count
	public void courseWiseCount() {

	    String sql = "SELECT c.course_name, COUNT(r.student_id) AS total " +
	                 "FROM course c " +
	                 "LEFT JOIN registration r ON c.course_id = r.course_id " +
	                 "GROUP BY c.course_id, c.course_name";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        boolean found = false;

	        while (rs.next()) {
	            found = true;
	            System.out.println(
	                rs.getString("course_name") + " -> " + rs.getInt("total")
	            );
	        }

	        if (!found) {
	            System.out.println("No courses found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
//	//delete or cancel registration records by id->transaction ke iye same connection jruri hai
//	public boolean deleteRegistrationRecordsById( int id) {
//		String sql = "DELETE FROM registration WHERE studentid=?";
//		try {
//			Connection con1 = DButil.getConnection();
//			PreparedStatement ps = con1.prepareStatement(sql);
//
//			ps.setInt(1, id);
//			return ps.executeUpdate() > 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	
	// delete registration BY studentiD
	public boolean deleteRegistrationRecordsById(Connection connection, int id) {
	    String sql = "DELETE FROM registration WHERE student_id=?";

	    try {
	    	PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.executeUpdate(); // even if 0 rows, it's fine becoz stdet k pass course enroll ho bhi skta ,nhi vbhi skta
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	//DELETE REGistration by course
	// DELETE registration by student + course
	public boolean deleteRegistrationByCourse(Connection con, int studentId, String courseName) {

	    String sql = "DELETE FROM registration WHERE student_id=? AND course_id = " +
	                 "(SELECT course_id FROM course WHERE course_name=?)";

	    try (PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, studentId);
	        ps.setString(2, courseName);

	        return ps.executeUpdate() > 0;   //must delte atleast one row

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
