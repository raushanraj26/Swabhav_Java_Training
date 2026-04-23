package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.monocept.JdbcConnection.DBConnection;

public class DeleteStudentbymarks {
	public static void main(String[] args) {
		try {
			// 1.connection
			Connection connection = DBConnection.getConnection();
			String query = "delete from college  where marks>?";
			// 2. Prepare statement
			PreparedStatement ps = connection.prepareStatement(query);

			
			
			ps.setDouble(1, 90.5);

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
