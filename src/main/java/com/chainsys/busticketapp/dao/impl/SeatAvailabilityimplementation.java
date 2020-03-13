package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.SeatAvailabilityDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.SeatAvailability;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;

@Repository
public class SeatAvailabilityimplementation implements SeatAvailabilityDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDAOImplementation.class);

	public void addAvailableSeatlist(SeatAvailability obj) throws DBException {
		String sql = "insert into seat_availability(bus_no,available_seats,total_seats) values(?,?,?)";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, obj.getBusNo());
			pst.setInt(2, obj.getAvailableSeats());
			pst.setInt(3, obj.getTotalSeats());
			int row = pst.executeUpdate();
			LOGGER.info("" + row);

		} catch (SQLException e) {
			throw new DBException("Unable to execute save AvailableSeats", e);
		}
	}

	public void deleteAvailableSeatlist(int busNo) throws DBException {
		String sql = "delete from seat_availability where bus_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, busNo);
			int row = pst.executeUpdate();
			LOGGER.info("" + row);
		} catch (SQLException e) {
			throw new DBException("unable to execute delete AvailablrSeats", e);
		}
	}

	public void updateAvailableSeatlist(int availableSeats, int busNo) throws DBException {
		String sql = "update seat_availability set available_seats=?" + " where bus_no= ?";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, availableSeats);
			pst.setInt(2, busNo);
			int row = pst.executeUpdate();
			LOGGER.info("" + row);
		} catch (SQLException e) {
			throw new DBException("unable to execute update AvailableSeats", e);
		}
	}

	public int availableSeatDetails(int busNo) throws DBException {
		String sql = "select *from seat_availability where bus_no=?";
		LOGGER.debug(sql);
		int seats = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, busNo);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					seats = rs.getInt("available_seats");
				}
			}
		} catch (SQLException e) {
			throw new DBException("unable to execute Seats find by busNo", e);
		}
		return seats;
	}

	public ArrayList<SeatAvailability> availablebusseats(String source, String destination) throws DBException {
		String sql = "select *from seat_availability where bus_no IN(select bus_no from bus_list where bus_source=? and bus_destination=?)";
		LOGGER.debug(sql);
		ArrayList<SeatAvailability> available = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, source);
			pst.setString(2, destination);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					SeatAvailability p = new SeatAvailability();
					p.setBusNo(rs.getInt("bus_no"));
					p.setAvailableSeats(rs.getInt("available_seats"));
					p.setTotalSeats(rs.getInt("total_seats"));
					available.add(p);
				}
				LOGGER.info("" + available.size());
			}
		} catch (SQLException e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return available;

	}

}
