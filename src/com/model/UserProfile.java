package com.model;

public class UserProfile {
	
	String fullName;
	String gender;
	String dob;
	String state;
	String city;
	String area;
	int pincode;
	String email;
	long mobile;
	String aadhar;
	String pancard;
	int account_no;
	String account_type;
	int account_balance;
	public UserProfile(String fullName, String gender, String dob, String state,
			String city, String area, int pincode, String email, long mobile, String aadhar, String pancard,
			int account_no, String account_type, int account_balance) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.dob = dob;
		this.state = state;
		this.city = city;
		this.area = area;
		this.pincode = pincode;
		this.email = email;
		this.mobile = mobile;
		this.aadhar = aadhar;
		this.pancard = pancard;
		this.account_no = account_no;
		this.account_type = account_type;
		this.account_balance = account_balance;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String firstName) {
		this.fullName = firstName;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	
	
	

}
