package com.services;

import java.util.ArrayList;

import com.model.AddPayee;

public interface AddPayeeService {
	
	public int addPayee(AddPayee ap);
	public ArrayList payeeList(int id);

}
