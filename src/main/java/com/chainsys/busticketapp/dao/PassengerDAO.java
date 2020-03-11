package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Passenger;

public interface PassengerDAO {
	
	public void addPassengerlist(Passenger obj)throws DBException;

	public void deletePassengerlist(int passengerId) throws DBException;

	public void updatePassengerlist(long passengerContact, int passengerId) throws DBException;

}
