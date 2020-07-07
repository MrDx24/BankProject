package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.UserProfile;

public class UserProfileDao extends Dao {

	private Connection con = null;
	private CallableStatement clstmt = null;
	private PreparedStatement ps = null;
	
	public ArrayList<UserProfile> userProfile(int id) {
		try {
			
			con = super.connect();
			ArrayList<UserProfile> lst = new ArrayList<UserProfile>();
			UserProfile userProfile = null;
			
			clstmt = con.prepareCall("{call userProfile(?)}");
			clstmt.setInt(1, id);
			
			ResultSet rs = clstmt.executeQuery();
			if(rs.next()) {
				String fullname = rs.getString("first_name")+"_"+rs.getString("middle_name")+"_"+rs.getString("last_name");
				
				userProfile = new UserProfile(fullname, rs.getString("gender"), rs.getString("date_of_birth"), 
						rs.getString("state"), rs.getString("city"), rs.getString("street"), rs.getInt("pincode"), 
						rs.getString("email"), rs.getLong("contact"), rs.getString("aadhar_card"), rs.getString("pan_card"), 
						rs.getInt("account_no"), rs.getString("account_type"), rs.getInt("account_balance"));
				
				lst.add(userProfile);
			}
			
			for(UserProfile up : lst) {
				System.out.println(up.getFullName()+" : "+up.getGender()+" : "+up.getDob());
				System.out.println(up.getState()+" : "+up.getCity()+" : "+up.getArea()+" : "+up.getPincode());
				System.out.println(up.getMobile()+" : "+up.getAadhar()+" : "+up.getPancard());
				System.out.println(up.getAccount_no()+" : "+up.getAccount_type()+" : "+up.getAccount_balance());
			}
			
			return lst;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
