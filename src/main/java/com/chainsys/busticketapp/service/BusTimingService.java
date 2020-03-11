package com.chainsys.busticketapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.TimingDAO;
import com.chainsys.busticketapp.model.BusTiming;
@Service
public class BusTimingService {
	@Autowired
	private TimingDAO timeing;
	
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
