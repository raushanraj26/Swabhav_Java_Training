package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.JdbcConnection.DBConnection;

public class DisplayStudentById {
	public static void main(String[] args) {
		
		String query = "Select * from college where id=?";
		try {
            // 1.connection
            Connection connection = DBConnection.getConnection();

            // 2. Prepare statement
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, 11);
            
            
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

            
//           ShowAllRecords.showStudent();

        } catch (Exception e) {
            e.printStackTrace();
        }


	}
}
