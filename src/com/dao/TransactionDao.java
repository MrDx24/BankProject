package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import org.apache.catalina.connector.Response;

import com.model.Transaction;

public class TransactionDao extends Dao {
	PreparedStatement ps =null;
	ResultSet rs = null;
	static 	int n ;
	String result ;

	public int checkPassword(int acc_no) {

		Connection con = super.orconnect();
		Transaction transaction =new Transaction();
		try {
			ps = con.prepareStatement("select trpsswwd from accounts where ACCOUNT_NO=? ");

			ps.setLong(1, acc_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				String result = rs.getString("trpsswwd");
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

		Connection con = super.orconnect();
		Transaction transaction =new Transaction();

		try {
			ps = con.prepareStatement("update accounts set trpsswwd= ? where account_no = ?");
			ps.setInt(1, pin);
			ps.setLong(2, acc_no);
			rs = ps.executeQuery();
			if(rs.next()) {
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
}
