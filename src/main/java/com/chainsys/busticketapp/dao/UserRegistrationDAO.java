package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.model.UserRegistration;

public interface UserRegistrationDAO {
	
	public void newUserRegister(UserRegistration obj) throws Exception;

	public void removeUser(int userId) throws Exception;
}
