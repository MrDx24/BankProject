package com.services;

import com.model.Login;

public interface Authenticate {
	public int validate(Login l) throws Exception;

}
