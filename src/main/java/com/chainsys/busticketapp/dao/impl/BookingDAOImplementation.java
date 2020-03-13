package com.chainsys.busticketapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.BookingDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Booking;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;

@Repository
public class BookingDAOImplementation implements BookingDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDAOImplementation.class);

	public String getEmail(int userId) throws DBException {
		String email = null;
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql = "select Email_id from user_register where user_id = ?";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, userId);
				ResultSet rs = pst.executeQuery();
				LOGGER.debug("" + rs);
				if (rs.next()) {
					email = rs.getString("Email_id");
					LOGGER.debug("EmailId:" + email);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to get mail", e);
		}
		return email;
	}

	public void save(Booking obj) throws DBException {
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement stmt = con.prepareCall("{call ticket_booking(?,?,?,?,?,?)}");) {
			stmt.setInt(1, obj.getBusNo());
			LOGGER.info("" + obj.getBusNo());
			stmt.setInt(2, obj.getPassengerId());
			LOGGER.info("" + obj.getPassengerId());
			stmt.setInt(3, obj.getNoOfTicket());
			stmt.setTimestamp(4, Timestamp.valueOf(obj.getJourneyDate()));
			// stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			LOGGER.info("" + obj.getNoOfTicket());
			stmt.setInt(5, obj.getUserId());
			stmt.registerOutParameter(6, Types.INTEGER);

			stmt.executeUpdate();
			int ticketNo = stmt.getInt(6);
			LOGGER.info("" + ticketNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to execute booking ticket", e);
		}

	}

	public void cancelTicket(int ticketNo) throws DBException {
		String sql = "delete from reserve where ticket_no=?";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection();) {
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, ticketNo);
				int row = pst.executeUpdate();
				LOGGER.info("" + row);
			}
		} catch (SQLException e) {
			throw new DBException("unable to execute cancel ticket", e);
		}
	}

	public ArrayList<Booking> findAll() throws DBException {
		String sql = "select * from reserve";
		LOGGER.debug(sql);
		ArrayList<Booking> List = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Booking obj = new Booking();
					obj.setTicketNo(rs.getInt("ticket_no"));
					obj.setBusNo(rs.getInt("bus_no"));
					obj.setPassengerId(rs.getInt("pas_id"));
					obj.setNoOfTicket(rs.getInt("no_of_ticket"));
					obj.setJourneyDate(rs.getTimestamp("journey_date").toLocalDateTime());
					obj.setTotalAmount(rs.getInt("total_amount"));
					obj.setStatus(rs.getString("status"));
					obj.setUserId(rs.getInt("user_id"));
					List.add(obj);
				}
			}
		} catch (SQLException e) {
			throw new DBException("unable to execute bookingDetails", e);
		}
		return List;
	}

	public int getBusNo(int ticketNo) throws DBException {
		int busid = 0;
		String sql = "select bus_no from reserve where ticket_no= ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, ticketNo);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					busid = rs.getInt("bus_no");
				}
			} catch (SQLException e) {
				throw new DBException(ErrorMessages.NO_DATA_FOUND, e);
			}
		}

		catch (SQLException e) {
			throw new DBException("unable to execute getBusNo", e);
		}
		return busid;
	}

	public boolean updateSeatAvailability(int noOfTickets, int busId) throws DBException {
		int row = 0;
		String sql = "update seat_availability set available_seats= (available_seats+?) where bus_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, noOfTickets);
			pst.setInt(2, busId);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Unable to update available seat availability", e);
		}
		if (row > 0)
			return true;
		else
			return false;
	}

	public void updateTotalAmount(int ticketNo, int passengerId, int noOfTicket) throws DBException {
		int row = 0;
		String sql = "update reserve r set total_amount = ( (no_of_ticket - ?)*(select amount from bus_time where bus_no=r.bus_no)),"
				+ "no_of_ticket=no_of_ticket- ? where ticket_no = ?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, noOfTicket);
			pst.setInt(2, noOfTicket);
			pst.setInt(3, ticketNo);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("unable to execute updateNoOfTicket", e);
		}
		LOGGER.info("No.of.rows updated:" + row);
	}

	public ArrayList<Booking> findMyTickets(int userId) throws DBException {
		String sql = "select * from reserve where user_id=?";
		LOGGER.debug(sql);
		ArrayList<Booking> myticket = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Booking obj = new Booking();
					obj.setTicketNo(rs.getInt("ticket_no"));
					obj.setBusNo(rs.getInt("bus_no"));
					obj.setPassengerId(rs.getInt("pas_id"));
					obj.setNoOfTicket(rs.getInt("no_of_ticket"));
					obj.setJourneyDate(rs.getTimestamp("journey_date").toLocalDateTime());
					obj.setTotalAmount(rs.getInt("total_amount"));
					obj.setStatus(rs.getString("status"));
					obj.setUserId(rs.getInt("user_id"));
					myticket.add(obj);
				}
			}
		} catch (SQLException e) {
			throw new DBException("unable to execute listMyTickets", e);
		}

		return myticket;
	}

}