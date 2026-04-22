package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.monocept.JdbcConnection.DBConnection;

public class BatchInsert {
	public static void main(String[] args) {
		
		String query = "INSERT INTO college (id, name, age, marks, branch) VALUES (?, ?, ?, ?, ?)";
		try {
            // 1.connection
            Connection connection = DBConnection.getConnection();

            // 2. Prepare statement
            PreparedStatement ps = connection.prepareStatement(query);
            
            
            //inserting batch wise using addbatch() and executebatch()
            
         // Student 1
            ps.setInt(1, 12);
            ps.setString(2, "Rahul");
            ps.setInt(3, 20);
            ps.setDouble(4, 85.5);
            ps.setString(5, "CSE");
            ps.addBatch();

            // Student 2
            ps.setInt(1, 13);
            ps.setString(2, "Anjali");
            ps.setInt(3, 21);
            ps.setDouble(4, 90.2);
            ps.setString(5, "IT");
            ps.addBatch();
            
         // Student 3
            ps.setInt(1, 14);
            ps.setString(2, "Amit");
            ps.setInt(3, 19);
            ps.setDouble(4, 78.0);
            ps.setString(5, "ECE");
            ps.addBatch();

            // Student 4
            ps.setInt(1, 15);
            ps.setString(2, "Sneha");
            ps.setInt(3, 22);
            ps.setDouble(4, 88.8);
            ps.setString(5, "CSE");
            ps.addBatch();

            // Student 5
            ps.setInt(1, 16);
            ps.setString(2, "Vikram");
            ps.setInt(3, 20);
            ps.setDouble(4, 67.5);
            ps.setString(5, "ME");
            ps.addBatch();
            
            
         // Execute all
            ps.executeBatch();

            
            
           ShowAllRecords.showStudent();

        } catch (Exception e) {
            e.printStackTrace();
        }


	}
}
