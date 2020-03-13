package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.UserRegistrationDAO;
import com.chainsys.busticketapp.model.UserRegistration;
@Service
public class UserRegistrationService {
	@Autowired
	private UserRegistrationDAO userregister;
	
	public void newUserRegister(UserRegistration obj) throws Exception{
		userregister.save(obj);
	}
	public void removeUser(int userId) throws Exception{
		userregister.remove(userId);
	}

}
