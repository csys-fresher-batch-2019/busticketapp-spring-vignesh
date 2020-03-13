package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.PassengerDAO;
import com.chainsys.busticketapp.model.Passenger;
@Service
public class PassengerService {
	@Autowired
	private PassengerDAO passenger;
	
	public void addPassengerlist(Passenger obj)throws Exception{
		passenger.save(obj);
	}

	public void deletePassengerlist(int passengerId) throws Exception{
		passenger.delete(passengerId);
	}

	public void updatePassengerlist(long passengerContact, int passengerId) throws Exception{
		passenger.update(passengerContact, passengerId);
	}

}



