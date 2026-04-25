package com.monocept.App.util;


import java.sql.Connection;
import java.sql.DriverManager;


public class DButil {
	private static final String URL = "jdbc:mysql://localhost:3306/coursemanagament";
    private static final String USER = "root";
    private static final String PASSWORD = "Raushanabesec@123";
  

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}

