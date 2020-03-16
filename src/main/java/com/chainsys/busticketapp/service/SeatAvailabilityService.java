package com.chainsys.busticketapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.SeatAvailabilityDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.model.SeatAvailability;
import com.chainsys.busticketapp.validator.SourceAndDestinationValidator;

@Service
public class SeatAvailabilityService {
	@Autowired
	private SeatAvailabilityDAO seatavaialbility;

	public void addAvailableSeatlist(SeatAvailability obj) throws Exception {
		try {
			seatavaialbility.save(obj);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void deleteAvailableSeatlist(int busNo) throws Exception {
		try {
			seatavaialbility.delete(busNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void updateAvailableSeatlist(int availableSeats, int busNo) throws Exception {
		try {
			seatavaialbility.update(availableSeats, busNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public int availableSeatDetails(int busNo) throws Exception {
		int availableSeats;
		try {
			availableSeats = seatavaialbility.findByBusNo(busNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return availableSeats;
	}

	public List<SeatAvailability> availablebusseats(String source, String destination) throws Exception {
		List<SeatAvailability> availablebusseats = new ArrayList<>();
		try {
			SourceAndDestinationValidator sourceValidator = new SourceAndDestinationValidator();
			sourceValidator.validateSearch(source, destination);
			availablebusseats = seatavaialbility.findBySourceDestination(source, destination);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return availablebusseats;

	}
}
