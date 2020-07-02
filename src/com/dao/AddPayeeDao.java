package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPayeeDao extends Dao {

	private Connection con = null;
	private CallableStatement clstmt = null;
	private PreparedStatement ps = null;
	
	public int addPayee() throws Exception {
		
		con = super.connect();
		
		ps=con.prepareStatement("select * from addpayee where acc");
		
		return 0;
		
	}
	
}
