package com.chainsys.busticketapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BusDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.model.Buses;
import com.chainsys.busticketapp.validator.SourceAndDestinationValidator;

@Service
public class BusTicketService {
	@Autowired
	private BusDAO busticket;

	// static Jdbi jdbi=ConnectionUtil.getJdbi();
	// static BusTicketDAO busticket=jdbi.onDemand(BusTicketDAO.class);
	public void addBuslist(int busNo, String busName, String busSource, String busDestination, String clazz)
			throws Exception {
		try {
			busticket.save(busName, busSource, busDestination, clazz);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/*
	 * void deleteBuslist(int busNo) throws Exception { try{
	 * busticket.deleteBuslist(busNo); } catch (DBException e) { throw new
	 * ServiceException(e.getMessage()); } }
	 */
	public int noOfBuses() throws Exception {
		try {
			return busticket.count();
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	HashMap<String, Integer> noOfBuslist() throws Exception {
		try {
			return busticket.findAllByBusName();
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<Buses> sourceStationlist(String busSource, String busDestination) throws ServiceException {

		List<Buses> sourceStationlist;
		try {
			SourceAndDestinationValidator sourceValidator = new SourceAndDestinationValidator();
			sourceValidator.validateSearch(busSource, busDestination);
			sourceStationlist = busticket.findBySourceDestination(busSource, busDestination);
		} catch (DBException | ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return sourceStationlist;
	}

}
