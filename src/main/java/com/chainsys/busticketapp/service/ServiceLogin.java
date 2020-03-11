package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.LoginDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.model.UserRegistration;
import com.chainsys.busticketapp.validator.UserValidator;

@Service
public class ServiceLogin {
	@Autowired
	private LoginDAO login;
	
	UserValidator uservalidator = new UserValidator();
	
	public boolean adminLogin(String adminname, String pass) throws ServiceException{
		boolean adminLogin=false;
	try {
		uservalidator.validateSearch(adminname,pass);
		adminLogin=login.adminLogin(adminname, pass);
	}
	catch (DBException | ValidatorException e) {
		
		throw new ServiceException(e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return adminLogin;
	}
	
	public UserRegistration user(String emailId, String pass) throws ServiceException{
		UserRegistration userLogin= null;
		try {
			
			uservalidator.validateSearch(emailId,pass);
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
	}
