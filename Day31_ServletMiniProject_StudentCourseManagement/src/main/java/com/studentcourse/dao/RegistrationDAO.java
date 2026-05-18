package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.Model.Registration;
import com.studentcourse.util.DbConnection;

public class RegistrationDAO {
//1.Add registration
	public void addRegistration(Registration registration) {

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	        "INSERT INTO registrations(student_id,course_id,registration_date,status) VALUES(?,?,?,?)";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, registration.getStudentId());

	        ps.setInt(2, registration.getCourseId());

	        ps.setString(3, registration.getRegistrationDate());

	        ps.setString(4, registration.getStatus());

	        ps.executeUpdate();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
	
//	2.Duplicate check
	public boolean isDuplicateActiveRegistration(
	        int studentId,
	        int courseId) {

	    boolean exists = false;

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	        "SELECT * FROM registrations WHERE student_id=? AND course_id=? AND status='Active'";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, studentId);

	        ps.setInt(2, courseId);

	        ResultSet rs =
	                ps.executeQuery();

	        if(rs.next()) {

	            exists = true;
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return exists;
	}
	
//	3.Get all registration
	public List<Registration> getAllRegistrations() {

	    List<Registration> registrationList =
	            new ArrayList<>();

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	        "SELECT * FROM registrations";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ResultSet rs =
	                ps.executeQuery();

	        while(rs.next()) {

	            Registration registration =
	                    new Registration();

	            registration.setRegistrationId(
	                    rs.getInt("registration_id"));

	            registration.setStudentId(
	                    rs.getInt("student_id"));

	            registration.setCourseId(
	                    rs.getInt("course_id"));

	            registration.setRegistrationDate(
	                    rs.getString("registration_date"));

	            registration.setStatus(
	                    rs.getString("status"));

	            registrationList.add(registration);
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return registrationList;
	}
	
//	4.Update status by id
	public void updateRegistrationStatus(
	        int registrationId,
	        String status) {

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	        "UPDATE registrations SET status=? WHERE registration_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setString(1, status);

	        ps.setInt(2, registrationId);

	        ps.executeUpdate();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
	
//	5.delete registration by id
	public void deleteRegistration(int registrationId) {

	    try {

	        Connection con =
	                DbConnection.getConnection();

	        String sql =
	        "DELETE FROM registrations WHERE registration_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, registrationId);

	        ps.executeUpdate();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
}
