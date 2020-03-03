package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.LoginDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.model.UserRegistration;

@Service
public class ServiceLogin {
	@Autowired
	private LoginDAO login;
	
	public boolean adminLogin(String adminname, String pass) throws ServiceException{
		boolean adminLogin=false;
	try {
		adminvalidateSearch(adminname,pass);
		adminLogin=login.adminLogin(adminname, pass);
	}
	catch (DBException | ValidatorException e) {
		
		throw new ServiceException(e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return adminLogin;
	}
	public void adminvalidateSearch(String adminname, String password) throws ValidatorException {
		if (adminname == null || adminname.equals("") || adminname.trim().equals("")) {
			throw new ValidatorException("Invalid AdminName");
		}
		if (password == null) {
			throw new ValidatorException("Invalid password");
		}
	}
	
	public UserRegistration user(String emailId, String pass) throws ServiceException{
		UserRegistration userLogin= null;
		try {
			uservalidateSearch(emailId,pass);
			userLogin=login.user(emailId, pass);
			System.out.println(userLogin);
			if ( userLogin == null) {
				throw new ServiceException("Invalid Login");
			}
		}
		catch (DBException | ValidatorException e) {
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userLogin;
		}
		public void uservalidateSearch(String userName, String password) throws ValidatorException {
			if (userName == null || userName.equals("") || userName.trim().equals("")) {
				throw new ValidatorException("Invalid UserName");
			}
			if (password == null) {
				throw new ValidatorException("Invalid password");
			}
		 
	}

}