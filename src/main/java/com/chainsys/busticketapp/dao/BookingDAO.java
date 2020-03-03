package com.chainsys.busticketapp.dao;

import java.util.ArrayList;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Booking;

public interface BookingDAO {
	
	void addReservationList(Booking obj) throws Exception;

	void cancelReservationList(int busNo) throws Exception;

	ArrayList<Booking> reserveDetails() throws Exception;
	
	public int getBusNo(int ticketNo) throws DBException;

	public void updateNoOfTicket(int ticketNo, int passengerId, int noOfTicket) throws Exception;
	
	ArrayList<Booking> listMyTickets(int userId) throws Exception;

}
