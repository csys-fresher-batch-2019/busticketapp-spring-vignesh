package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.SeatAvailability;

public interface SeatAvailabilityDAO {
	
	public void save(SeatAvailability obj) throws DBException;

	public void delete(int busNo) throws DBException;

	public void update(int availableSeats, int busNo) throws DBException;
	
	public int findByBusNo(int busNo) throws DBException;
	
	public List<SeatAvailability> findBySourceDestination(String source, String destination) throws DBException;

}
