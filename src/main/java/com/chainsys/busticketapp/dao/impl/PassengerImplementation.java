package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.PassengerDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Passenger;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;

@Repository
public class PassengerImplementation implements PassengerDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDAOImplementation.class);

	public void addPassengerlist(Passenger obj) throws DBException {
		String sql = "insert into passenger (pas_id,pas_name,pas_age,pas_gender,pas_contact)values (pas_id.nextval,?,?,?,?)";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, obj.getPassengerName());
			pst.setInt(2, obj.getPassengerAge());
			pst.setString(3, obj.getPassengerGender());
			pst.setLong(4, obj.getPassengerContact());
			int row = pst.executeUpdate();
			// int result=obj.getPassengerId();
			LOGGER.info("" + row);
			/*
			 * if(row==1) { Mail.send("vignesh280519@gmail.com","6369541046",
			 * "vigneshn051995@gmail.com"," Thanks for using this application "
			 * ,"Your PassengerID:",obj.getPassengerId()); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePassengerlist(int passengerId) throws DBException {

		String sql = "delete from passenger where pas_id=?";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, passengerId);
			int row = pst.executeUpdate();
			LOGGER.info("" + row);
		} catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
	}

	public void updatePassengerlist(long passengerContact, int passengerId) throws DBException {

		String sql = "update passenger set pas_contact=? where pas_id=?";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setLong(1, passengerContact);
			pst.setInt(2, passengerId);
			int row = pst.executeUpdate();
			LOGGER.info("" + row);

		} catch (Exception e) {
			throw new DBException(ErrorMessages.INVALID_PHONE_NO, e);
		}
	}
}