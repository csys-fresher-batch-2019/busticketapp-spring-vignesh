package com.chainsys.busticketapp.util;

import java.util.ArrayList;

import com.chainsys.busticketapp.DBException;
import com.chainsys.busticketapp.dao.BookingDAO;
import com.chainsys.busticketapp.dao.impl.BookingDAOImplementation;
import com.chainsys.busticketapp.model.Booking;

public class ServiceReservation {
	private BookingDAO reservation = new BookingDAOImplementation();

	void addReservationList(Booking obj) throws Exception {
		reservation.addReservationList(obj);
	}

	void cancelReservationList(int busNo) throws Exception {
		reservation.cancelReservationList(busNo);
	}

	ArrayList<Booking> reserveDetails() throws Exception {
		ArrayList<Booking> reserveDetails = new ArrayList<>();
		try{
			reserveDetails=reservation.reserveDetails();
		}catch (DBException e) {
			throw new ServiceException(e.getMessage());
	}
		return reserveDetails;
	}
	public int getBusNo(int ticketNo) throws DBException {
		int ticketNumber;
		try {
			ticketNumber = reservation.getBusNo(ticketNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return ticketNumber;
	}

	public void updateNoOfTicket(int ticketNo, int passengerId, int noOfTicket) throws Exception {
		reservation.updateNoOfTicket(ticketNo, passengerId, noOfTicket);
	}

}
