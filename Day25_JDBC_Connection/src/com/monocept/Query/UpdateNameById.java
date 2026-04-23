package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.JdbcConnection.DBConnection;

public class UpdateNameById {
//	Update the name of a student using their id.
public static void main(String[] args) {
		
		try {
			// 1.connection
			Connection connection = DBConnection.getConnection();
			String query = "update college set name=? where id=?";
			// 2. Prepare statement
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, "ABc");
			ps.setInt(2, 1);

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
