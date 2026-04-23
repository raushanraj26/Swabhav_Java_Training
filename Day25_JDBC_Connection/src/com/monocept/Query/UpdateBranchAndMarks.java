package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.monocept.JdbcConnection.DBConnection;

public class UpdateBranchAndMarks {
//	Update both branch and marks of a student based on their id.
	public static void main(String[] args) {
		try {
			// 1.connection
			Connection connection = DBConnection.getConnection();
			String query = "update college set branch=? , marks=? where id=?";
			// 2. Prepare statement
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, "Ds");
			ps.setDouble(2, 85.45);
			
			ps.setInt(3, 1);

			// 4. Execute (CORRECT METHOD)
			int result = ps.executeUpdate();
			System.out.println(result);
			
			
			
			
			ShowAllRecords.showStudent();
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
