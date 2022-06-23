package com.brainmentors.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface CommonDAO {
	public static Connection createConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String CONNECTION_STRING="jdbc:mysql://localhost:3306/chatdb";
			final String USER_ID="root";
			final String PASSWORD="MySQL123@#";
			
			Connection con=DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
			return con;

	}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return null;
	
		
	}
	
}
