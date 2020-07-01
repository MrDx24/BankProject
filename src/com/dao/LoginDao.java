package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Login;
import com.services.Authenticate;

public class LoginDao extends Dao implements Authenticate{
	private Connection con = null;
	//private CallableStatement clstmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public LoginDao() {

	}

	public Connection orconnect() {
		// TODO Auto-generated method stub
		System.out.println("in LoginDao : ");
		return super.orconnect();
	}

	public int validate(Login login) throws Exception {
			
			con = orconnect();
			ps = con.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("userid");
				 return id;
			}
			else {
				return -1;
			}
	}




}