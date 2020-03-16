package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.User;

public interface UserDAO {
	
	public void save(User obj) throws DBException;

	public void remove(int userId) throws DBException;
}
