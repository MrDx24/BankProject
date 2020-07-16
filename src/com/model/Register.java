package com.model;

public class Register {
	
	Customer customer;
	
	String account_type;
	String username;
	String password;
	String opdate;
	
	public Register(Customer customer, String account_type, String username, String password) {
		super();
		this.customer =  customer;
		
		this.account_type = account_type;
		this.username = username;
		this.password = password;
		
	}
	
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
	
}
