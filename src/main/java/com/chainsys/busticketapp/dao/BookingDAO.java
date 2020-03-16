package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Booking;

public interface BookingDAO {
	public String getEmail(int userId) throws DBException;

	void save(Booking obj) throws DBException;

	void cancelTicket(int busNo) throws DBException;

	List<Booking> findAll() throws DBException;

	public int getBusNo(int ticketNo) throws DBException;

	public void updateTicketDetails(int ticketNo, int passengerId, int noOfTicket) throws DBException;

	List<Booking> findMyTickets(int userId) throws DBException;

	boolean updateSeatAvailability(int noOfTickets, int busId) throws DBException;

}
