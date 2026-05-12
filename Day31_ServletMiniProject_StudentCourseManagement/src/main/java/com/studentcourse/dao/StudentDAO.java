package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.studentcourse.Model.Student;
import com.studentcourse.util.DbConnection;



public class StudentDAO {
//	1.Add student
	public void addStudent(Student student) {

        try {

            Connection con =
                    DbConnection.getConnection();

            String sql =
                "INSERT INTO students(student_name,email,phone,age,city) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,student.getStudentName());
            ps.setString( 2,student.getEmail() );
            ps.setString(3,student.getPhone());         
            ps.setInt(4,student.getAge() );
            ps.setString(5,student.getCity());
        ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
