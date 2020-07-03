package com.test;

import java.time.LocalDateTime;

import com.dao.AddPayeeDao;
import com.dao.RegisterDao;
import com.model.Customer;
import com.model.Register;

public class Test {

	public static void main(String[] args) {
//		LocalDateTime currentTime = LocalDateTime.now();
//		String date = currentTime.toString();
//		Customer c = new Customer("Daneil", "DRon","McKooger", "Male","12/10/1999","Maharashtra", "Pune", "Kasba Peth", 411004, "ryan12@gmail.com", "9128734655", 
//				"928314567834", "TGKKKW7856C", "Indian");
//		Register r = new Register(c,"Savings","ry12", "ry1234", date);
//		RegisterDao dao = new RegisterDao();
		AddPayeeDao dao = new AddPayeeDao();
		try {
			int i = dao.addPayee(1000000008);
			System.out.println("ans : " + i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
