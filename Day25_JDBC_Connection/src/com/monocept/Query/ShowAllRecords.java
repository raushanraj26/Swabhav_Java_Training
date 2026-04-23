package com.monocept.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.JdbcConnection.DBConnection;

public class ShowAllRecords {
	public static void showStudent() {
        

        try  {
        	Connection con = DBConnection.getConnection();
        	String query = "SELECT * FROM college";
        	PreparedStatement ps = con.prepareStatement(query);
        	ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getDouble("marks") + " " +
                    rs.getString("branch")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
