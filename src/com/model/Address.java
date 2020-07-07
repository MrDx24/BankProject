package com.model;

public class Address {
	
	private String state;
	private String city;
	private String area;
	private String pincode;
	
	public Address(String state, String city, String area, String pincode) {
		super();
		this.state = state;
		this.city = city;
		this.area = area;
		this.pincode = pincode;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	
}
