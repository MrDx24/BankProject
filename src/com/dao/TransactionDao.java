package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

//import org.apache.catalina.connector.Response;

import com.model.SetPin;

public class TransactionDao extends Dao {
	PreparedStatement ps =null;
	CallableStatement clstmt = null;
	int rs = 0;
	static 	int n ;
	String result ;

	public int checkPassword(int acc_no) {
		ResultSet rs=null;
		Connection con = super.connect();
		SetPin transaction =new SetPin();
		try {
			ps = con.prepareStatement("select trpsswd from accounts where ACCOUNT_NO=? ");

			ps.setLong(1, acc_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				String result = rs.getString("trpsswd");
				if (result.equals("not_set")) {
					System.out.println("UPI is not set");
					n=-1;
				}
				else {
					System.out.println("UPI is set");
					n= 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	static int m;
	public int setpassword(int acc_no, int pin) {

		Connection con = super.connect();
		SetPin transaction =new SetPin();

		try {
			ps = con.prepareStatement("update accounts set trpsswd= ? where account_no = ?");
			ps.setInt(1, pin);
			ps.setInt(2, acc_no);
			rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("set");
				m=1;
			}
			else {
				System.out.println("not set");
				m=-1;
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;

	}
	
	public int trancsactionProcess(int sender_acc, int reciever_acc, int res) {
		
		try {
			con = super.connect();
			
			int ans = 0;
			clstmt = con.prepareCall("{?=call transactionProcess(?,?,?)}");
			clstmt.registerOutParameter(1, JDBCType.INTEGER);
			clstmt.setInt(2, sender_acc);
			clstmt.setInt(3, reciever_acc);
			clstmt.setInt(4, res);
			clstmt.execute();
			ans = clstmt.getInt(1);
			return ans;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return -4;
		}
		
		
		
		
	} 
	
	public int checkTrpsswd(int accno, String psswd) {
		try {
			
			con = super.connect();
			int ans = 0;
			clstmt = con.prepareCall("{?=call check_tr_psswd(?,?)}");
			clstmt.registerOutParameter(1, JDBCType.INTEGER);
			clstmt.setInt(2, accno);
			clstmt.setString(3, psswd);
			
			clstmt.execute();
			
			ans = clstmt.getInt(1);
			
			return ans;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -2;
		}

	}
	
	public int account_balance(int accno) {
		try {
			
			con = super.connect();
			int ans = 0;
			clstmt = con.prepareCall("{?=call account_balance(?)}");
			clstmt.registerOutParameter(1, JDBCType.INTEGER);
			clstmt.setInt(2, accno);
			
			clstmt.execute();
			
			ans = clstmt.getInt(1);
			
			return ans;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -2;
		}

	}
	
}
