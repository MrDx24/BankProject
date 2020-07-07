package com.test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.dao.AddPayeeDao;
import com.dao.RegisterDao;
import com.model.AddPayee;
import com.model.Customer;
import com.model.Register;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {

		AddPayeeDao dao = new AddPayeeDao();
		AddPayee ap = new AddPayee(1000000006, 1000000004, "Kevin", "Savings");
		try {
			int ans = dao.addPayee(ap);
			System.out.println("ans : " + ans);
			if(ans == -1) {
				System.out.println("User with this account number does not exists. ");
			}
			if(ans == -2) {
				System.out.println("User with this account number is already added to your payee list. ");
			}
			if(ans == -3) {
				System.out.println("Unknown error. Please try again later. ");
			}
			if(ans == 1) {
				System.out.println("Added successfully");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<AddPayee> lst = dao.payeeList(1000000006);
		
	}

}
