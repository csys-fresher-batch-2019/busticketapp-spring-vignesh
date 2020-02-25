package com.chainsys.busticketapp.util;

import java.util.ArrayList;

import com.chainsys.busticketapp.DBException;
import com.chainsys.busticketapp.dao.SeatAvailabilityDAO;
import com.chainsys.busticketapp.dao.impl.SeatAvailabilityimplementation;
import com.chainsys.busticketapp.model.SeatAvailability;

public class ServiceSeatAvailability {

	private SeatAvailabilityDAO seatavaialbility = new SeatAvailabilityimplementation();
	
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
	
	public ArrayList<SeatAvailability> availablebusseats(String source, String destination) throws Exception{
		ArrayList<SeatAvailability> availablebusseats = new ArrayList<>();
		try{
			availablebusseats=seatavaialbility.availablebusseats(source, destination);
		}catch (DBException e) {
			throw new ServiceException(e.getMessage());
	}
		return availablebusseats;
		
		
	}
}
