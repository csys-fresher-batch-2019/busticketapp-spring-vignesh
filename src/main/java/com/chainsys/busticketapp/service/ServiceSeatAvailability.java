package com.chainsys.busticketapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.SeatAvailabilityDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.model.SeatAvailability;
import com.chainsys.busticketapp.validator.SourceDestinationValidator;
@Service
public class ServiceSeatAvailability {
	@Autowired
	private SeatAvailabilityDAO seatavaialbility;
	
	public void addAvailableSeatlist(SeatAvailability obj) throws Exception{
		seatavaialbility.addAvailableSeatlist(obj);
	}

	public void deleteAvailableSeatlist(int busNo) throws Exception{
		seatavaialbility.deleteAvailableSeatlist(busNo);
	}

	public void updateAvailableSeatlist(int availableSeats, int busNo) throws Exception{
		seatavaialbility.updateAvailableSeatlist(availableSeats, busNo);
	}
	
	public int availableSeatDetails(int busNo) throws Exception{
		int availableSeats;
		try {
			availableSeats = seatavaialbility.availableSeatDetails(busNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return availableSeats;		
	}
	
	public List<SeatAvailability> availablebusseats(String source, String destination) throws Exception{
		List<SeatAvailability> availablebusseats = new ArrayList<>();
		try{
			SourceDestinationValidator sourceValidator = new SourceDestinationValidator();
			sourceValidator.validateSearch(source, destination);
			availablebusseats=seatavaialbility.availablebusseats(source, destination);
		}catch (DBException e) {
			throw new ServiceException(e.getMessage());
	}
		return availablebusseats;
		
		
	}
}
