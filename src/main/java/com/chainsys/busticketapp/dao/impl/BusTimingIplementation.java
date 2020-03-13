package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.TimingDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.BusTiming;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;

@Repository
public class BusTimingIplementation implements TimingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BusTicketManagerImplimentation.class);

	public void addBusTiming(BusTiming obj) throws DBException {
		String sql = "insert into bus_time(bus_no,amount,departure_time,arrival_time) values(?,?,?,?)";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, obj.getBusNo());
			pst.setInt(2, obj.getAmount());
			pst.setTime(3, Time.valueOf(obj.getDepartureTime()));
			pst.setTime(4, Time.valueOf(obj.getArrivalTime()));
			// pst.setString(3, obj.getDepartureTime());
			// pst.setString(4, obj.getArrivalTime());
			int row = pst.executeUpdate();
			LOGGER.info("" + row);
		} catch (SQLException e) {
			throw new DBException("unable to execute save bustime", e);
		}
	}

	public void deleteBusTiming(int busNo) throws DBException {
		String sql = "delete from bus_time where bus_no=?";
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, busNo);
			int row = pst.executeUpdate();
			LOGGER.info("" + row);

		} catch (SQLException e) {
			throw new DBException("unable to execute delete bustime", e);
		}
	}

	public List<BusTiming> bustimeDetails() throws DBException {
		String sql = "select * from bus_time";
		LOGGER.debug(sql);
		ArrayList<BusTiming> List = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				BusTiming obj = new BusTiming();
				obj.setBusNo(rs.getInt("bus_no"));
				obj.setAmount(rs.getInt("amount"));
				obj.setDepartureTime(rs.getTime("departure_time").toLocalTime());
				obj.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
				List.add(obj);

			}
		} catch (SQLException e) {
			throw new DBException("unable to execute bustime details", e);
		}
		return List;

	}

	public BusTiming bustimes(int busNo) throws DBException {
		String sql = "select * from bus_time where bus_no=" + busNo;
		BusTiming obj = null;
		LOGGER.debug(sql);
		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			if (rs.next()) {
				obj = new BusTiming();
				obj.setBusNo(rs.getInt("bus_no"));
				obj.setAmount(rs.getInt("amount"));
				obj.setDepartureTime(rs.getTime("departure_time").toLocalTime());
				obj.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
			}
		} catch (SQLException e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return obj;

	}

}
