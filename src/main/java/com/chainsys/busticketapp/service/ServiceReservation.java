package com.chainsys.busticketapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BookingDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.model.Booking;
import com.chainsys.busticketapp.util.mail.Mail;
@Service
public class ServiceReservation {
	@Autowired
	private BookingDAO reservation;

	public void addReservationList(Booking obj) throws Exception {
		String email = reservation.getEmail(obj.getUserId());
		System.out.println(email);
		reservation.addReservationList(obj);
		
			Mail.send("vignesh280519@gmail.com", "6369541046", email, " Your Ticket is Booked ",
					"Thanks for using this application", obj.getPassengerId());
	
	}

	void cancelReservationList(int busNo) throws Exception {
		reservation.cancelReservationList(busNo);
	}

	List<Booking> reserveDetails() throws Exception {
		List<Booking> reserveDetails = new ArrayList<>();
		try{
			reserveDetails=reservation.bookingDetails();
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

	public List<Booking> listMyTickets(int userId) throws Exception{
		List<Booking> reserveDetails = new ArrayList<>();
		try{
			reserveDetails=reservation.listMyTickets(userId);
		}catch (DBException e) {
			throw new ServiceException(e.getMessage());
	}
		return reserveDetails;
		
	}

}
