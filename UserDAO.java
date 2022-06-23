package com.brainmentors.chatapp.dao;
//Contains the USER CRUD Operations.


import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.Encryption;


public class UserDAO {
	
	public  boolean isLogin(UserDTO userdto) throws SQLException, NoSuchAlgorithmException {
		Connection connection=null;
		PreparedStatement pstmt=null;
	    
		final String sql="select user_id from users where user_id=? and password=?";
		try {
			
			connection=CommonDAO.createConnection();
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,userdto.getUserid());
			String encryptPassword=Encryption.passwordEncrypt(new String(userdto.getPassword()));
			pstmt.setString(2,encryptPassword);
			ResultSet rs=pstmt.executeQuery();
			return rs.next();
		}
		finally {
//			if(rs!=null) 
//			rs.close();
			if(pstmt!=null)
				pstmt.close();
					if(connection!=null)
				connection.close();
		}
		
	}
	public int add(UserDTO userdto) throws SQLException, NoSuchAlgorithmException {
		//System.out.println("Received"+userdto.getUserid()+" "+userdto.getPassword());
		Connection connection=null;
		Statement stmt=null;
		try {//Guarded Region
		connection=CommonDAO.createConnection();
		stmt=connection.createStatement();//Step 1 Connection Created.
		
		//We do a query;
		String sql="insert into users(user_id,password,city,phoneno,email) values('"+userdto.getUserid()+"','"+Encryption.passwordEncrypt(new String(userdto.getPassword()))+"','"+userdto.getCity()+"','"+userdto.getPhone()+"','"+userdto.getEmail()+"')";
		int record=stmt.executeUpdate(sql);
		return record;
		}
		finally {//always execute(Resource Cleaning)
			if(stmt!=null)
		stmt.close();
			if(connection!=null)
		connection.close();
		}
		
	}
	
	public boolean update(UserDTO userdto) throws SQLException, NoSuchAlgorithmException {
		//System.out.println("Received"+userdto.getUserid()+" "+userdto.getPassword());
		Connection connection=null;
		PreparedStatement pstmt=null;
		final String sql="update users set password=? where user_id=?";
		try {
			
			connection=CommonDAO.createConnection();
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(2,userdto.getUserid());
			String encryptPassword=Encryption.passwordEncrypt(new String(userdto.getPassword()));
			pstmt.setString(1,encryptPassword);
			pstmt.executeUpdate();
			return true;
		}
		finally {
//			if(rs!=null) 
//			rs.close();
			if(pstmt!=null)
				pstmt.close();
					if(connection!=null)
				connection.close();
		}
		
	}
	
}

