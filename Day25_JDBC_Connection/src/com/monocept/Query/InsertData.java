package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.monocept.JdbcConnection.DBConnection;

public class InsertData {
	public static void main(String[] args) {

        String query = "INSERT INTO college (id,name, age, marks, branch) VALUES (?,?, ?, ?, ?)";

        try {
            // 1.connection
            Connection connection = DBConnection.getConnection();

            // 2. Prepare statement
            PreparedStatement preparaedstatement = connection.prepareStatement(query);

            // 3. Set values
            preparaedstatement.setInt(1, 11);
            preparaedstatement.setString(2, "Rahul");
            preparaedstatement.setInt(3, 20);
            preparaedstatement.setDouble(4, 85.5);
            preparaedstatement.setString(5, "CSE");

            int rows = preparaedstatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Data inserted successfully!");
            }

           ShowAllRecords.showStudent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}
