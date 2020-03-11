package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.UserRegistration;

public interface UserRegistrationDAO {
	
	public void newUserRegister(UserRegistration obj) throws DBException;

	public void removeUser(int userId) throws DBException;
}
