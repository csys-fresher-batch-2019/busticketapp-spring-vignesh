package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.model.BusTiming;

public interface TimingDAO {
	
	void addBusTiming(BusTiming obj) throws Exception;

	void deleteBusTiming(int busNo) throws Exception;

	List<BusTiming> bustimeDetails() throws Exception;
	
	public BusTiming bustimes(int busNo) throws Exception;

}
