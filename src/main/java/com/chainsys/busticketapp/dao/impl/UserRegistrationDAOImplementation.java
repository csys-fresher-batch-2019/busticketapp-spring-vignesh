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

@Repository
public class UserRegistrationDAOImplementation implements UserRegistrationDAO {
	UserRegistration obj = new UserRegistration();
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDAOImplementation.class);

	public void newUserRegister(UserRegistration obj) throws DBException {
		String sql = "insert into User_register(name,Email_id,password,contact,user_id) values(?,?,?,?,user_id.nextval)";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, obj.getUserName());
			pst.setString(2, obj.getEmailId());
			pst.setString(3, obj.getPassword());
			pst.setLong(4, obj.getContactNumber());
			int row = pst.executeUpdate();
			LOGGER.info("" + row);
		} catch (SQLException e) {
			throw new DBException("NEW User unable to execute", e);
		}
	}

	public void removeUser(int userId) throws DBException {
		String sql = "delete from User_register where user_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			int row = pst.executeUpdate();
			LOGGER.info("" + row);
		} catch (SQLException e) {
			throw new DBException("Remove user unable to execute", e);
		}
	}
}