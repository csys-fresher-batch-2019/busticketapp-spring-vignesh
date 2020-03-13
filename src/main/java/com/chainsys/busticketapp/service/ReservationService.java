package com.chainsys.busticketapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BookingDAO;
import com.chainsys.busticketapp.dao.impl.BookingDAOImplementation;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.model.Booking;
import com.chainsys.busticketapp.util.mail.Mail;
@Service
public class ReservationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDAOImplementation.class);
	@Autowired
	private BookingDAO reservation;

	public String getEmail(int userId) throws ValidatorException{
		String email=null;
		try {
			email = reservation.getEmail(userId);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return email;
		
	}

	public void addReservationList(Booking obj) throws Exception {
		String email = reservation.getEmail(obj.getUserId());
		LOGGER.info(email);
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
		BookingDAOImplementation imp = new BookingDAOImplementation();
		int busId = imp.getBusNo(ticketNo);
		LOGGER.info("",busId);
		boolean result = imp.updateSeatAvailability(noOfTicket, busId);
		LOGGER.debug("",result);
		if(result == true) {
			imp.updateTotalAmount(ticketNo, passengerId, noOfTicket);
		}
		else
			throw new Exception("Unable to updateNoOfTicket");
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
