package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.services.Main;

public class Dao {

	String url = "jdbc:mysql://localhost:3306/bank";
	String username = "root";
	String password = "root";


	String orurl = "jdbc:oracle:thin:@localhost:1521:xe";
	String orusername = "system";
	String orpassword = "sanket123";

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

	public Connection orconnect() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(orurl, orusername, orpassword); 

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return con; 


	}


}
