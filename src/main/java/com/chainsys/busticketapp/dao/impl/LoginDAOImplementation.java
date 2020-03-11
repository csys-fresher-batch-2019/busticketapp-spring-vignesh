package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.LoginDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.UserRegistration;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;

@Repository
public class LoginDAOImplementation implements LoginDAO {
	public boolean adminLogin(String adminName, String pass) throws DBException {

		boolean valid = false;
		String sql = "select Admin_name from AdminRegister where Admin_name=? and pass_word = ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, adminName);
			pst.setString(2, pass);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					valid = true;
				}
			} catch (SQLException e) {
				throw new Exception("Unable to execute login query");
			}
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return valid;
	}
	// user Login

	public UserRegistration user(String emailId, String password) throws DBException {
		String sql = "select user_id,name,Email_id from User_register where Email_id=? and password=?";
		UserRegistration u = null;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, emailId);
			pst.setString(2, password);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					u = new UserRegistration();
					u.setUserId(rs.getInt("user_id"));
					u.setUserName(rs.getString("name"));
					u.setEmailId(rs.getString("Email_id"));

				}
			}
		} catch (SQLException e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return u;
	}
}
