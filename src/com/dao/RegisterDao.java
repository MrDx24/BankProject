package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.model.Register;
import com.services.AccountCreation;
import com.services.Main;

public class RegisterDao extends Dao implements AccountCreation {

	
	private Connection con = null;
	private CallableStatement clstmt = null;
	
	
			
	public RegisterDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Connection connect() {
		// TODO Auto-generated method stub
		System.out.println("in RegisterDao : ");
		return super.connect();
	}

	@Override
	public int setDetails(Register r) {
		
		try {
			
			con = connect();
			
			clstmt = con.prepareCall("{call insert_account(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			clstmt.setString(1, r.getAccName());
			clstmt.setString(2, r.getGender());
			clstmt.setString(3, r.getDob());
			clstmt.setString(4, r.getState());
			clstmt.setString(5, r.getCity());
			clstmt.setString(6, r.getArea());
			clstmt.setInt(7, r.getPincode());
			clstmt.setString(8, r.getEmail());
			clstmt.setString(9, r.getMobile());
			clstmt.setString(10, r.getAadhar());
			clstmt.setString(11, r.getPancard());
			clstmt.setString(12, r.getNationality());
			clstmt.setString(13, r.getUsername());
			clstmt.setString(14, r.getPassword());
			clstmt.setString(15, r.getOpdate());
			
			
			boolean result = clstmt.execute();
			System.out.println(result);
			if(result) {
				return 0;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	
	

	
}
