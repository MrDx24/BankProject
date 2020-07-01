package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;

import com.model.Customer;
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
			Customer customer = r.getCustomer();
			clstmt = con.prepareCall("{call insert_customers(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			clstmt.setString(1, customer.getFirstName());
			clstmt.setString(2, customer.getMiddleName());
			clstmt.setString(3, customer.getLastName());
			clstmt.setString(4, customer.getGender());
			clstmt.setString(5, customer.getDob());
			clstmt.setString(6, customer.getState());
			clstmt.setString(7, customer.getCity());
			clstmt.setString(8, customer.getArea());
			clstmt.setInt(9, customer.getPincode());
			clstmt.setString(10, customer.getEmail());
			clstmt.setString(11, customer.getMobile());
			clstmt.setString(12, customer.getAadhar());
			clstmt.setString(13, customer.getPancard());
			clstmt.setString(14, customer.getNationality());
			clstmt.registerOutParameter(15, JDBCType.INTEGER);
			
			boolean result = clstmt.execute();
			System.out.println(result);
			if(result==false) {
				int cid = clstmt.getInt(15);
				clstmt = con.prepareCall("{call insert_account(?,?,?,?,?)}");
				clstmt.setInt(1, cid);
				clstmt.setString(2, r.getAccount_type());
				clstmt.setString(3, r.getUsername());
				clstmt.setString(4, r.getPassword());
				clstmt.setString(5, r.getOpdate());
				boolean accres = clstmt.execute();
				int res ;
				res = (accres==true) ? 0 : -1 ;
				return res;
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
