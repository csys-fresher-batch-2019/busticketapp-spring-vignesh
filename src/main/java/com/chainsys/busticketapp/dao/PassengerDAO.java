package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Passenger;

public interface PassengerDAO {
	
	public void save(Passenger obj)throws DBException;

	public void delete(int passengerId) throws DBException;

	public void update(long passengerContact, int passengerId) throws DBException;

}
