package com.chainsys.busticketapp.util;

import java.util.List;

import com.chainsys.busticketapp.dao.TimingDAO;
import com.chainsys.busticketapp.dao.impl.BusTimingIplementation;
import com.chainsys.busticketapp.model.BusTiming;

public class ServiceBusTiming {
	private TimingDAO timeing = new BusTimingIplementation();
	
	void addBusTiming(BusTiming obj) throws Exception{
		timeing.addBusTiming(obj);
	}

	void deleteBusTiming(int busNo) throws Exception{
		timeing.deleteBusTiming(busNo);
	}

	List<BusTiming> bustimeDetails() throws Exception{
	return timeing.bustimeDetails();	
	}
	
	public BusTiming bustimes(int busNo) throws Exception{
		return timeing.bustimes(busNo);
	}
	

}
