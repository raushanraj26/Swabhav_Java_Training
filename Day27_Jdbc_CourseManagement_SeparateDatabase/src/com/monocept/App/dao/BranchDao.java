package com.monocept.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.monocept.App.util.DButil;

public class BranchDao {
	public void showAllBranches() {
	    String sql = "SELECT branch_id, branch_name FROM branch";

	    try (Connection con = DButil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        System.out.println("Available Branches:");
	        while (rs.next()) {
	            System.out.println(
	                rs.getInt("branch_id") + " → " + rs.getString("branch_name")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
