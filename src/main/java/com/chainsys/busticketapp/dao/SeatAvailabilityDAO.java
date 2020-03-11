package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.SeatAvailability;

public interface SeatAvailabilityDAO {
	
	public void addAvailableSeatlist(SeatAvailability obj) throws DBException;

	public void deleteAvailableSeatlist(int busNo) throws DBException;

	public void updateAvailableSeatlist(int availableSeats, int busNo) throws DBException;
	
	public int availableSeatDetails(int busNo) throws DBException;
	
	public List<SeatAvailability> availablebusseats(String source, String destination) throws DBException;

}
