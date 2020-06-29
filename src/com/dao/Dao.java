package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.services.Main;

public class Dao {

	String url = "jdbc:mysql://localhost:3306/bank";
	String username = "root";
	String password = "root";
	
	public Connection con = null;
	
	public Dao() {
		// TODO Auto-generated constructor stub
	}

	
	public Connection connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password); 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return con; 
		
		
	}

	

}
