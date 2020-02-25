package com.chainsys.busticketapp.util;

import com.chainsys.busticketapp.dao.PassengerDAO;
import com.chainsys.busticketapp.dao.impl.PassengerImplementation;
import com.chainsys.busticketapp.model.Passenger;

public class ServicePassenger {
	private PassengerDAO passenger = new PassengerImplementation();
	
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



