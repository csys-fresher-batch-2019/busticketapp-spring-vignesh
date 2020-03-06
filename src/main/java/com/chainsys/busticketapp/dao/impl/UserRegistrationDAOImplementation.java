package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.UserRegistrationDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.UserRegistration;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;
@Repository
public class UserRegistrationDAOImplementation implements UserRegistrationDAO {
	UserRegistration obj = new UserRegistration();
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDAOImplementation.class);
	public void newUserRegister(UserRegistration obj) throws Exception {
		String sql = "insert into User_register(name,Email_id,password,contact,user_id) values(?,?,?,?,user_id.nextval)";
		LOGGER.debug(sql);
		try(Connection con = ConnectionUtil.getConnection();){
				try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, obj.getUserName());
		pst.setString(2, obj.getEmailId());
		pst.setString(3, obj.getPassword());
		pst.setLong(4, obj.getContactNumber());
		//pst.setInt(5, obj.getUserId());
		int row = pst.executeUpdate();
		LOGGER.info(""+row);
		}
		catch(SQLException e) {
			throw new Exception("Unable to execute login query");
		}
	}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}
	public void removeUser(int userId) throws Exception {
		String sql = "delete from User_register where user_id=?";
		try(Connection con = ConnectionUtil.getConnection();){
			try(PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, userId);
			int row = pst.executeUpdate();
			LOGGER.info(""+row);

	}
		catch(SQLException e) {
			throw new Exception("Unable to execute login query");
		}
	}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
}
}