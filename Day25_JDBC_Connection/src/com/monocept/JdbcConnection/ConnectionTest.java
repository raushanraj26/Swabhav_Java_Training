package com.monocept.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class ConnectionTest {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/College";
            String user = "root";
            String password = "Raushanabesec@123";

            // 1. Connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // 2. Query
           String query = "SELECT * FROM college";
           
            PreparedStatement ps = connection.prepareStatement(query);

            // 3. Execute
            ResultSet rs = ps.executeQuery();

            // 4. Process
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
        }
    }
}

