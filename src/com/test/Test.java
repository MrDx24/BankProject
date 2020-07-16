package com.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.dao.AccountStatementDao;
import com.dao.AddPayeeDao;
import com.dao.RegisterDao;
import com.dao.TransactionDao;
import com.dao.UserProfileDao;
import com.model.AddPayee;
import com.model.Customer;
import com.model.Register;
import com.model.Transaction;
import com.model.UserProfile;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {
		
//		acc_st();
//		payeeList();
//		deletePayee();
//		payeeList();
		//checktrpsswd();
		transactions();
		
	}
	
	public static void userProfile() {
		UserProfileDao dao = new UserProfileDao();

		try {
			ArrayList<UserProfile> lst = new ArrayList<UserProfile>();
			lst = dao.userProfile(1000000006);
			System.out.println(lst.get(0).getFullName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void addPayee() {
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
		
	}
	
	public static void deletePayee() {
		AddPayeeDao dao = new AddPayeeDao();
		int ans = dao.deletePayee(1000000000, 1000000000);
		System.out.println(ans);
	}
	
	public static void payeeList() {
		AddPayeeDao dao = new AddPayeeDao();
		ArrayList<AddPayee> lst = dao.payeeList(1000000000);
		AddPayeeDao apdao = new AddPayeeDao();
//		ArrayList<AddPayee> ap = apdao.payeeList(1000000008);
//		System.out.println(ap);
//		if(ap.size()<=0){
//			System.out.println("null");
//		}
	}
	
	public static void acc_st() {
		AccountStatementDao dao = new AccountStatementDao();
		String from_date = "2020-07-08";
		String to_date = "2020-07-09";
		Date fr_date =  dao.dateConverter(from_date);
		Date t_date = dao.dateConverter(to_date);
		
		System.out.println(fr_date+" : "+t_date);
		
		ArrayList<Transaction> lst = dao.account_statement(1000000000, from_date, to_date);
		for(Transaction tr : lst) {
			String check = tr.getOperation();
			System.out.println(check);
			if(check.equals("sent")) {
				System.out.println("- "+tr.getAmount()+"");
			}
			if(check.equals("recieved")) {
				System.out.println("+ "+tr.getAmount()+"");
			}
		}
	}
	
	public static void transactions() {
		try { 

			TransactionDao dao = new TransactionDao();
			int res = dao.trancsactionProcess(1000000000, 1000000001, 100);
			if(res == -1) {
				System.out.println("Cannot perform transaction. Reason : Balance is less than minimiun balance");
			}
			if(res == -2) {
				System.out.println("Not sufficient balance");	
			}
			if(res == -3) {
				System.out.println("Cannot perform transaction. Reason : Balance going less than minimiun balance");
			}
			if(res == -4) {
				System.out.println("Unknown error");
			}
			if(res == 1) {
				System.out.println("Transfered successfully");
			}
		}	
		catch (Exception e) {
			// TODO: handle exception_date
			e.printStackTrace();
		}
	}
	 
	public static void checktrpsswd() {
		TransactionDao dao = new TransactionDao();
		int res = dao.checkTrpsswd(1000000000,"1234");
		if(res == 1) {
			System.out.println("Successfully");
		}
		if(res == -1) {
			System.out.println("Cannot perform transaction. Reason : Balance going less than minimiun balance");	
		}
		if(res == -2) {
			System.out.println("Unknown error");
		}
		
	}
}



	


