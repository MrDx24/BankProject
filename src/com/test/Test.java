package com.test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.dao.AddPayeeDao;
import com.dao.RegisterDao;
import com.dao.UserProfileDao;
import com.model.AddPayee;
import com.model.Customer;
import com.model.Register;
import com.model.UserProfile;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {

//		AddPayeeDao dao = new AddPayeeDao();
//		AddPayee ap = new AddPayee(1000000006, 1000000004, "Kevin", "Savings");
//		try {
//			int ans = dao.addPayee(ap);
//			System.out.println("ans : " + ans);
//			if(ans == -1) {
//				System.out.println("User with this account number does not exists. ");
//			}
//			if(ans == -2) {
//				System.out.println("User with this account number is already added to your payee list. ");
//			}
//			if(ans == -3) {
//				System.out.println("Unknown error. Please try again later. ");
//			}
//			if(ans == 1) {
//				System.out.println("Added successfully");
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		ArrayList<AddPayee> lst = dao.payeeList(1000000006);
		UserProfileDao dao = new UserProfileDao();
		
		try {
			ArrayList<UserProfile> lst = new ArrayList<UserProfile>();
			lst = dao.userProfile(1000000006);
			System.out.println(lst.get(0).getFullName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
