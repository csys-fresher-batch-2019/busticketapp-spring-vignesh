package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.User;

public interface LoginDAO {
	
	//@SqlUpdate("select Admin_name from AdminRegister where Admin_name=? and pass_word = ?")
	public boolean adminLogin(String adminname, String pass) throws DBException;
	
	//@SqlUpdate("select name from UserRegister where Email_id=? and password=?")
	public User userLogin(String emailId, String pass) throws DBException ;
}
