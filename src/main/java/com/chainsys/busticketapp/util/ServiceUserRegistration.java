package com.chainsys.busticketapp.util;

import com.chainsys.busticketapp.dao.UserRegistrationDAO;
import com.chainsys.busticketapp.dao.impl.UserRegistrationDAOImplementation;
import com.chainsys.busticketapp.model.UserRegistration;

public class ServiceUserRegistration {

	private UserRegistrationDAO userregister = new UserRegistrationDAOImplementation();
	
	public void newUserRegister(UserRegistration obj) throws Exception{
		userregister.newUserRegister(obj);
	}
	public void removeUser(int userId) throws Exception{
		userregister.removeUser(userId);
	}

}
