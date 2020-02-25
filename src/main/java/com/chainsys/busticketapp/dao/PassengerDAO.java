package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.model.Passenger;

public interface PassengerDAO {
	
	public void addPassengerlist(Passenger obj)throws Exception;

	public void deletePassengerlist(int passengerId) throws Exception;

	public void updatePassengerlist(long passengerContact, int passengerId) throws Exception;

}
