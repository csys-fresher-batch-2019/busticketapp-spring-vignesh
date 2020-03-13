package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.BusTiming;

public interface TimingDAO {
	
	void save(BusTiming obj) throws DBException;

	void delete(int busNo) throws DBException;

	List<BusTiming> findAll() throws DBException;
	
	public BusTiming findByBusNo(int busNo) throws DBException;

}
