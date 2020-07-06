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

	

	public int validate(Login login) throws Exception {
			
			con = super.orconnect();
			//con = super.connect();
			//ps = con.prepareStatement("select * from accounts where username=? and password=?");
			ps = con.prepareStatement("select * from accounts where usename=? and password=?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("account_no");
				System.out.println(id);
				return id;
			}
			else {
				return -1;
			}
	}

}
