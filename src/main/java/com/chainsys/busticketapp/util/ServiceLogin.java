package com.chainsys.busticketapp.util;

import com.chainsys.busticketapp.DBException;
import com.chainsys.busticketapp.dao.LoginDAO;
import com.chainsys.busticketapp.dao.impl.LoginDAOImplementation;
import com.chainsys.busticketapp.model.UserRegistration;

public class ServiceLogin {
	private LoginDAO login = new LoginDAOImplementation();
	
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
	
	public UserRegistration user(String name, String pass) throws ServiceException{
		UserRegistration userLogin= null;
		try {
			uservalidateSearch(name,pass);
			userLogin=login.user(name, pass);
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