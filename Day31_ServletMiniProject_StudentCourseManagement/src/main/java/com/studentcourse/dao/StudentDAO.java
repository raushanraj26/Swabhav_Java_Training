package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.Model.Student;
import com.studentcourse.util.DbConnection;

public class StudentDAO {
//	1.Add student
	public void addStudent(Student student) {

		try {

			Connection con = DbConnection.getConnection();

			String sql = "INSERT INTO students(student_name,email,phone,age,city) VALUES(?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getPhone());
			ps.setInt(4, student.getAge());
			ps.setString(5, student.getCity());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	2.Get All students
	public List<Student> getAllStudents() {

		List<Student> studentList = new ArrayList<>();

		try {

			Connection con = DbConnection.getConnection();

			String sql = "SELECT * FROM students";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Student student = new Student();

				// Auto-generated ID coming from database
				student.setStudentId(rs.getInt("student_id"));

				student.setStudentName(rs.getString("student_name"));

				student.setEmail(rs.getString("email"));

				student.setPhone(rs.getString("phone"));

				student.setAge(rs.getInt("age"));

				student.setCity(rs.getString("city"));

				studentList.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentList;
	}

//	3 Get Student by Id
	public Student getStudentById(int id) {
		Student student = null;
		try {
			Connection con = DbConnection.getConnection();
			String sql = "SELECT * FROM students WHERE student_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setEmail(rs.getString("email"));
				student.setPhone(rs.getString("phone"));
				student.setAge(rs.getInt("age"));
				student.setCity(rs.getString("city"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}

//	4.Update student by Id

	public void updateStudent(Student student) {
		try {
			Connection con = DbConnection.getConnection();

			String sql = "UPDATE students SET student_name=?, email=?, phone=?, age=?, city=? WHERE student_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, student.getStudentName());

			ps.setString(2, student.getEmail());

			ps.setString(3, student.getPhone());

			ps.setInt(4, student.getAge());

			ps.setString(5, student.getCity());

			ps.setInt(6, student.getStudentId());

			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//	5.Delete student by id

	public void deleteStudent(int studentId) {

		try {

			Connection con = DbConnection.getConnection();

			String sql = "DELETE FROM students WHERE student_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, studentId);

			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
