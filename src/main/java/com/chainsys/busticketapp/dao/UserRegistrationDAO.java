package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.UserRegistration;

public interface UserRegistrationDAO {
	
	public void save(UserRegistration obj) throws DBException;

	public void remove(int userId) throws DBException;
}
