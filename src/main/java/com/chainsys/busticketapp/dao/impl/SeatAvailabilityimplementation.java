package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.SeatAvailabilityDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.SeatAvailability;
import com.chainsys.busticketapp.util.ConnectionUtil;
import com.chainsys.busticketapp.util.ErrorMessages;
import com.chainsys.busticketapp.util.logger.Logger;
@Repository
public class SeatAvailabilityimplementation implements SeatAvailabilityDAO {
	Logger logger=Logger.getInstance();
	public void addAvailableSeatlist(SeatAvailability obj) throws Exception {
		String sql = "insert into seat_availability(bus_no,available_seats,total_seats) values(?,?,?)";
		logger.debug(sql);
		try(Connection con = ConnectionUtil.getConnection();){
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setInt(1, obj.getBusNo());
		pst.setInt(2, obj.getAvailableSeats());
		pst.setInt(3, obj.getTotalSeats());
		int row = pst.executeUpdate();
		logger.info(row);
	}
		catch(SQLException e) {
			throw new Exception("Unable to execute login query");
		}
	}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public void deleteAvailableSeatlist(int busNo) throws Exception {
		String sql = "delete from seat_availability where bus_no=?";
		try(Connection con = ConnectionUtil.getConnection();){
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setInt(1, busNo);
		int row = pst.executeUpdate();
		logger.info(row);
	}
	catch(SQLException e) {
		throw new Exception("Unable to execute login query");
	}
	}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}
	public void updateAvailableSeatlist(int availableSeats, int busNo) throws Exception {
		String sql = "update seat_availability set available_seats=?" + " where bus_no= ?";
		logger.debug(sql);
		try(Connection con = ConnectionUtil.getConnection();){
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setInt(1, availableSeats);
		pst.setInt(2, busNo);
		int row = pst.executeUpdate();
		logger.info(row);
		}
		catch(SQLException e) {
			throw new Exception("Unable to execute login query");
		}
	}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
	}
	public int availableSeatDetails(int busNo) throws Exception {
		String sql = "select *from seat_availability where bus_no=?";
		logger.debug(sql);
		int seats = 0;
		try(Connection con = ConnectionUtil.getConnection();){
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setInt(1, busNo);
		try(ResultSet rs = pst.executeQuery();){
		if (rs.next()) {
			seats = rs.getInt("available_seats");
		}
		}
		catch(SQLException e) {
			throw new Exception("Unable to execute login query");
		}
		}
		catch(SQLException e) {
			throw new Exception("Unable to execute  preparedstatement query");
		}
		}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		return seats;
	}
	

	public ArrayList<SeatAvailability> availablebusseats(String source, String destination) throws Exception {
		String sql = "select *from seat_availability where bus_no IN(select bus_no from bus_list where bus_source=? and bus_destination=?)";
		logger.debug(sql);
		ArrayList<SeatAvailability> available = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection();){
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, source);
		pst.setString(2, destination);
		try(ResultSet rs = pst.executeQuery();){
		while (rs.next()) {
			SeatAvailability p = new SeatAvailability();
			p.setBusNo(rs.getInt("bus_no"));
			p.setAvailableSeats(rs.getInt("available_seats"));
			p.setTotalSeats(rs.getInt("total_seats"));
			available.add(p);
		}
		logger.info(available.size());
		}
		catch(SQLException e) {
			throw new Exception("Unable to execute login query");
		}
		}
		catch(SQLException e) {
			throw new Exception("Unable to execute preparedstatement query");
		}
		}
		catch (Exception e) {
			throw new DBException(ErrorMessages.CONNECTION_FAILURE);
		}
		return available;

	}

}
