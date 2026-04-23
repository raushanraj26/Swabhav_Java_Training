package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.JdbcConnection.DBConnection;

public class StudentAgebetween {
	// Display students whose age lies between two given values.

	public static void main(String[] args) {
		
		try {
			// 1.connection
			Connection connection = DBConnection.getConnection();
			String query = "select * from college where age between ? and ?";
			// 2. Prepare statement
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, 21);
			ps.setInt(2, 22);

			// 4. Execute (CORRECT METHOD)
			ResultSet rs = ps.executeQuery();

			// 5. Print result
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double marks = rs.getDouble("marks");
				String branch = rs.getString("branch");

				System.out.println(id + " " + name + " " + age + " " + marks + " " + branch);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
