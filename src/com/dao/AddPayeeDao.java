package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPayeeDao extends Dao {

	private Connection con = null;
	private CallableStatement clstmt = null;
	private PreparedStatement ps = null;
	
	public int addPayee(int id) throws Exception {
		
		con = super.connect();
		
		clstmt =con.prepareCall("{?=call checkUserExist(?)}");
		clstmt.registerOutParameter(1, JDBCType.INTEGER);
		clstmt.setInt(2, id);
		
		clstmt.execute();
		int ans = clstmt.getInt(1);
		if(ans == 1){
			return ans;
		}
		else{
			return ans;
		}
//		return 0;
		
	}
	
}
