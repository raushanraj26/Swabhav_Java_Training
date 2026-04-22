package com.monocept.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/College";
    private static final String USER = "root";
    private static final String PASSWORD = "456";
//    Connection connection = null;
//    //constructor
//    public DBConnection() {
//    	try {
//        connection = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//    	
//    }

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
