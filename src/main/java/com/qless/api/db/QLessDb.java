package com.qless.api.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qless.api.utils.Kiosk;


public class QLessDb {
	private Connection conn;
	public QLessDb(){
	  
		try {
       	 if (conn == null){
			  Class.forName("com.mysql.jdbc.Driver");
		     conn =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3305/qless",  "admin", "kentish");
	         conn.setAutoCommit(true);
			}
		
		} catch (SQLException ex){
			ex.printStackTrace();
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	public void createNewKiosk(Kiosk kiosk){
		
		String sqlstmt = "INSERT INTO account (userid) values (?)"; 
	
		try {
			PreparedStatement prepStmt = conn.prepareStatement(sqlstmt);
			
			prepStmt.setString(1, kiosk.getUserid());
			
			prepStmt.execute("use qless");
			prepStmt.executeUpdate();
			prepStmt.close();
			 } catch (SQLException ex){
				 ex.printStackTrace();
				 
			 }
	}

}
