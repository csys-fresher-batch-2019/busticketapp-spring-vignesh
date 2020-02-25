package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.busticketapp.DBException;
import com.chainsys.busticketapp.ErrorMessages;
import com.chainsys.busticketapp.dao.PassengerDAO;
import com.chainsys.busticketapp.dao.impl.mail.Mail;
import com.chainsys.busticketapp.logger.Logger;
import com.chainsys.busticketapp.model.Passenger;
import com.chainsys.busticketapp.util.ConnectionUtil;

public class PassengerImplementation implements PassengerDAO
{
	Logger logger = Logger.getInstance();
	public void addPassengerlist(Passenger obj) throws Exception {
		String sql = "insert into passenger (pas_id,pas_name,pas_age,pas_gender,pas_contact)values (pas_id.nextval,?,?,?,?)";
		logger.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, obj.getPassengerName());
			pst.setInt(2, obj.getPassengerAge());
			pst.setString(3, obj.getPassengerGender());
			pst.setLong(4, obj.getPassengerContact());
			 int row=pst.executeUpdate();
			//int result=obj.getPassengerId();
			logger.info(row);
			/*if(row==1) {
				Mail.send("vignesh280519@gmail.com","6369541046","vigneshn051995@gmail.com"," Thanks for using this application ","Your PassengerID:",obj.getPassengerId());
			} */	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePassengerlist(int passengerId) throws Exception {

		String sql = "delete from passenger where pas_id=?";
		logger.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, passengerId);
			int row = pst.executeUpdate();
			logger.info(row);
		} catch (SQLException e) {
			throw new Exception("Unable to execute delete query");
		}
	}

	public void updatePassengerlist(long passengerContact, int passengerId) throws Exception {

		String sql = "update passenger set pas_contact=? where pas_id=?";
		logger.debug(sql);
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setLong(1, passengerContact);
				pst.setInt(2, passengerId);
				int row = pst.executeUpdate();
			logger.info(row);
			} catch (SQLException e) {
				throw new Exception("Unable to execute query");
			}
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}
}