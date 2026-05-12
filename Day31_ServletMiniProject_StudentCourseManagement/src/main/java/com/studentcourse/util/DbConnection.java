package com.studentcourse.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/student_course";
    private static final String USER = "root";
    private static final String PASSWORD = "Raushanabesec@123";
  
 // Static block -> load driver only once
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
        	
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Db connection Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
