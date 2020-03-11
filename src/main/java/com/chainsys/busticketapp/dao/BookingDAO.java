package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Booking;

public interface BookingDAO {
	public String getEmail(int userId) throws DBException;
	
	void addReservationList(Booking obj) throws DBException;

	void cancelReservationList(int busNo) throws DBException;

	List<Booking> bookingDetails() throws DBException;
	
	public int getBusNo(int ticketNo) throws DBException;

	public void updateNoOfTicket(int ticketNo, int passengerId, int noOfTicket) throws DBException;
	
	List<Booking> listMyTickets(int userId) throws DBException;

}
