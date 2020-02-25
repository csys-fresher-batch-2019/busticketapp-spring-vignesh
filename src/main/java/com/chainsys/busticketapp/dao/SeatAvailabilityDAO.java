package com.chainsys.busticketapp.dao;

import java.util.ArrayList;

import com.chainsys.busticketapp.model.SeatAvailability;

public interface SeatAvailabilityDAO {
	
	public void addAvailableSeatlist(SeatAvailability obj) throws Exception;

	public void deleteAvailableSeatlist(int busNo) throws Exception;

	public void updateAvailableSeatlist(int availableSeats, int busNo) throws Exception;
	
	public int availableSeatDetails(int busNo) throws Exception;
	
	public ArrayList<SeatAvailability> availablebusseats(String source, String destination) throws Exception;

}
