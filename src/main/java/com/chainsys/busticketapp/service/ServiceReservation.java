package com.chainsys.busticketapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BookingDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.model.Booking;
@Service
public class ServiceReservation {
	@Autowired
	private BookingDAO reservation;

	public void addReservationList(Booking obj) throws Exception {
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

	public ArrayList<Booking> listMyTickets(int userId) throws Exception{
		ArrayList<Booking> reserveDetails = new ArrayList<>();
		try{
			reserveDetails=reservation.listMyTickets(userId);
		}catch (DBException e) {
			throw new ServiceException(e.getMessage());
	}
		return reserveDetails;
		
	}

}
