package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.BusTiming;

public interface TimingDAO {
	
	void addBusTiming(BusTiming obj) throws DBException;

	void deleteBusTiming(int busNo) throws DBException;

	List<BusTiming> bustimeDetails() throws DBException;
	
	public BusTiming bustimes(int busNo) throws DBException;

}
