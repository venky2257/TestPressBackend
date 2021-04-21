package com.example.testpress_test.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	static Connection getRemoteConnection() {
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");  
	    	  System.out.println("Getting remote connection with connection string from environment variables.");
	    	  Connection con=DriverManager.getConnection(  
	    			  "jdbc:mysql://localhost:3306/testpress_test","root","123456");  
	    	  System.out.println("Remote connection successful.");
		      return con;
		    }
		    catch (ClassNotFoundException e) { 
		    	System.out.println(e.toString());}
		    catch (SQLException e) { 
		    	System.out.println(e.toString());}
		      catch (Exception e) {
		    	  System.out.println(e.toString());}
		    return null;
	      }
	
	public static void main(String[] args) throws SQLException {
		Connection con = DbUtils.getRemoteConnection();
		System.out.println(con);
	}
	
}
