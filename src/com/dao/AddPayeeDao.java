package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.model.AddPayee;

public class AddPayeeDao extends Dao {

	private Connection con = null;
	private CallableStatement clstmt = null;
	private PreparedStatement ps = null;
	
	public int addPayee(AddPayee ap)  {
		System.out.println("in addpayee ");
		try {
		con = super.connect();
		
		clstmt =con.prepareCall("{?=call checkUserExist(?,?,?,?)}");
		clstmt.registerOutParameter(1, JDBCType.INTEGER);
		clstmt.setInt(2, ap.getAccountNo());
		clstmt.setInt(3, ap.getPayeeAccNo());
		clstmt.setString(4, ap.getAccountName());
		clstmt.setString(5, ap.getAccountType());
		
		clstmt.execute();
		int ans = clstmt.getInt(1);
//		if(ans == 1){
//			return ans;
//		}
//		else{
//			return ans;
//		}
		return ans;
		}
		catch (Exception e) {
			// TODO: handle exception
			return -3;
		}
	}
	
	public ArrayList payeeList(int id) {
		System.out.println("in addpayee list");
		ArrayList<AddPayee> lst = new ArrayList<AddPayee>();
		AddPayee ap ;
		try { 
			con = super.connect();
			
			clstmt = con.prepareCall("{call payeeList(?)}");
			clstmt.setInt(1, id);
			ResultSet rs = clstmt.executeQuery();
			while(rs.next()) {
				ap = new AddPayee(rs.getInt("acc_no"), rs.getInt("payee_acc_no"), rs.getString("acc_name"), rs.getString("acc_type"));
				lst.add(ap);
			}
			for (AddPayee addPayee : lst) {
				System.out.println(addPayee.getAccountNo()+":"+ addPayee.getAccountName()+":"+addPayee.getPayeeAccNo()+":"+addPayee.getAccountType());
			}
			
			return lst;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
		
	}
	
}
