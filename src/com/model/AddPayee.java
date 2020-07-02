package com.model;

public class AddPayee {
	
	int accountNo;
	String accountName;
	String accountType;
	public AddPayee(int accountNo, String accountName, String accountType) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.accountType = accountType;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
