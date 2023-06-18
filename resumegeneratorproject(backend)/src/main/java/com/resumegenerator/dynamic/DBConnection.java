package com.resumegenerator.dynamic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	 public Connection getConnection() {
	        Connection connection = null;
	        System.out.println("Connection called");
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resumeportal", "root", "Ankit12345");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
	}


