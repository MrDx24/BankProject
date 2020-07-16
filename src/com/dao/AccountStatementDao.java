package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.model.Transaction;

public class AccountStatementDao extends Dao {
	
	private Connection con = null;
	private CallableStatement clstmt = null;
	private ResultSet rs=null;
	
	public ArrayList<Transaction> account_statement(int acc_no, String from_date, String to_date) {
		
		try {
			con = super.connect();
			ArrayList<Transaction> lst = new ArrayList<Transaction>();
			Date fr_date = dateConverter(from_date);
			Date t_date = dateConverter(to_date);
			clstmt = con.prepareCall("{call account_statement(?,?,?)}");
			clstmt.setInt(1, acc_no);
			clstmt.setDate(2, fr_date);
			clstmt.setDate(3, t_date);
			
			rs = clstmt.executeQuery();
			Transaction tr;
			while(rs.next()) {
				tr = new Transaction(rs.getInt("tr_id"), rs.getInt("account_no"), rs.getInt("amount"), rs.getDate("tr_date"), rs.getString("tr_time"), rs.getString("operation"));
				lst.add(tr);
			}
			for(Transaction tr1: lst){
				System.out.println(tr1.getTransaction_id()+" : "+tr1.getPayee_acc_no()+" : "+tr1.getAmount()+" : "+tr1.getTransaction_date()+" : "+tr1.getTransaction_time()+" : "+tr1.getOperation());
			}
			return lst;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	public java.sql.Date dateConverter(String change_date) {
		try{
		java.util.Date or_date = new SimpleDateFormat("yyyy-MM-dd").parse(change_date);
		long time = or_date.getTime();
		java.sql.Date output_date = new java.sql.Date(time);
		return output_date;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
