package com.monocept.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.App.model.Student;
import com.monocept.App.util.DButil;

public class StudentDao {
	//addstudent
	public boolean addStudent(Student s) {
		  String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";

	        try  {
	        	Connection connection = DButil.getConnection();
	        	 PreparedStatement ps = connection.prepareStatement(sql);

	            ps.setInt(1, s.getId());
	            ps.setString(2, s.getName());
	            ps.setInt(3, s.getAge());
	            ps.setString(4, s.getBranch());

	            return ps.executeUpdate() > 0;

	        } catch (Exception e) {
	            System.out.println("Duplicate ID or DB error");
	        }
	        return false;
	}
	
	//Display student by id
	public Student getStudentById(int id) {
		String sql = "SELECT * FROM student WHERE id=?";

        try {
        	Connection con = DButil.getConnection();
        	PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            
                  //it returns only one student,if multiple then use list<student>
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("branch")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	
	
	
	//update name and branch of student whose id
	public boolean updateStudent(int id, String name, String branch) {
	    String sql = "UPDATE student SET name=?, branch=? WHERE id=?";

	    try  {
	    	Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, name);
	        ps.setString(2, branch);
	        ps.setInt(3, id);

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	//delete student by id
	public boolean deleteStudent(Connection con, int id)  {
        String sql = "DELETE FROM student WHERE id=?";
        try  {
        	Connection con1 = DButil.getConnection();
	         PreparedStatement ps = con1.prepareStatement(sql);

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }catch (Exception e) {
	        e.printStackTrace();
	    }
        return false;
    }

}
