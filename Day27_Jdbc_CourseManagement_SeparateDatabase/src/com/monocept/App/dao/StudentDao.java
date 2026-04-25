package com.monocept.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.App.model.Student;
import com.monocept.App.util.DButil;

public class StudentDao {
	// addstudent
	public boolean addStudent(Student s) {
	    String sql = "INSERT INTO student (id, name, age, branch_id) VALUES (?, ?, ?, ?)";

	    try (Connection connection = DButil.getConnection();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setInt(1, s.getId());
	        ps.setString(2, s.getName());
	        ps.setInt(3, s.getAge());
	        ps.setInt(4, s.getBranchId()); // ✅ changed

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    return false;
	}
//	check Student exist or not by id
	public boolean StudentAlreadyExist(int id) {
		String sql = "SELECT id FROM student WHERE id=?";

		try {
			Connection connection = DButil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	// Display student by id
	public void getAllStudents() {
	    String sql = "SELECT s.id, s.name, s.age, b.branch_id, b.branch_name FROM student s JOIN branch b ON s.branch_id = b.branch_id";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            System.out.println(
	                "ID: " + rs.getInt("id") +
	                ", Name: " + rs.getString("name") +
	                ", Age: " + rs.getInt("age") +
	                ", Branch ID: " + rs.getInt("branch_id") +
	                ", Branch Name: " + rs.getString("branch_name")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// update name and branch id of student whose id
	public boolean updateStudent(int id, String name, int branchId) {

	    String sql = "UPDATE student SET name=?, branch_id=? WHERE id=?";

	    try  {
	    	Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, name);
	        ps.setInt(2, branchId); 
	        ps.setInt(3, id);

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

//	// delete student by id
//	public boolean deleteStudent( int id) {
//		String sql = "DELETE FROM student WHERE id=?";
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
//	

	
	// delete student
	public boolean deleteStudent(Connection connection, int id) {
	    String sql = "DELETE FROM student WHERE id=?";

	    try  {
	    	PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
