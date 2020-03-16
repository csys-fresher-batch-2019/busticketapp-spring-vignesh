package com.chainsys.busticketapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.TimingDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.model.BusTiming;

@Service
public class BusTimingService {
	@Autowired
	private TimingDAO timeing;

	void addBusTiming(BusTiming obj) throws Exception {
		try {
			timeing.save(obj);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	void deleteBusTiming(int busNo) throws Exception {
		try {
			timeing.delete(busNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	List<BusTiming> bustimeDetails() throws Exception {
		try {
			return timeing.findAll();
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public BusTiming bustimes(int busNo) throws Exception {
		try {
			return timeing.findByBusNo(busNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
