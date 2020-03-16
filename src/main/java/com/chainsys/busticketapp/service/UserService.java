package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.UserDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.model.User;

@Service
public class UserService {
	@Autowired
	private UserDAO user;

	public void saveUser(User obj) throws Exception {
		try {
			user.save(obj);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void removeUser(int userId) throws Exception {
		try {
			user.remove(userId);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
