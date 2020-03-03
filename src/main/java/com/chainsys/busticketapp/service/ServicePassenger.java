package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.PassengerDAO;
import com.chainsys.busticketapp.model.Passenger;
@Service
public class ServicePassenger {
	@Autowired
	private PassengerDAO passenger;
	
	public void addPassengerlist(Passenger obj)throws Exception{
		passenger.addPassengerlist(obj);
	}

	public void deletePassengerlist(int passengerId) throws Exception{
		passenger.deletePassengerlist(passengerId);
	}

	public void updatePassengerlist(long passengerContact, int passengerId) throws Exception{
		passenger.updatePassengerlist(passengerContact, passengerId);
	}

}



