package com.test;

import java.time.LocalDateTime;

import com.dao.RegisterDao;
import com.model.Register;

public class Test {

	public static void main(String[] args) {
		LocalDateTime currentTime = LocalDateTime.now();
		String date = currentTime.toString();
		Register r = new Register("Ryan Ron Kooger", "Male","12/10/1999","Maharashtra", "Pune", "Kasba Peth", 411004, "ryan12@gmail.com", "9128734655", 
				"928314567834", "TGKKKW7856C", "Indian", "ry12", "ry1234", date);
		RegisterDao dao = new RegisterDao();
		int i = dao.setDetails(r);
		if(i==0) {
			System.out.println("Successful");
		}
		else {
			System.out.println("not");
		}

	}

}
