package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.PassengerDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.model.Passenger;

@Service
public class PassengerService {
	@Autowired
	private PassengerDAO passenger;

	public void addPassengerlist(Passenger obj) throws Exception {
		try {
			passenger.save(obj);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void deletePassengerlist(int passengerId) throws Exception {
		try {
			passenger.delete(passengerId);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void updatePassengerlist(long passengerContact, int passengerId) throws Exception {
		try {
			passenger.update(passengerContact, passengerId);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public int findPassengerId() throws Exception {
		int id = 0;
		try {
			id = passenger.findPassengerId();
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return id;
	}

}
