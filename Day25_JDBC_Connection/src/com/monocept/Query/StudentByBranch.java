package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.JdbcConnection.DBConnection;

public class StudentByBranch {
	
	public static void main(String[] args) {
		// Display all students belonging to a specific branch.
		try {
			// 1.connection
			Connection connection = DBConnection.getConnection();
			String query = "select * from college where branch =?";
			// 2. Prepare statement
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, "IT");

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
