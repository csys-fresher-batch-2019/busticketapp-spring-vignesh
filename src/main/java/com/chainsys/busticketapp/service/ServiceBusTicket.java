package com.chainsys.busticketapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BusTicketDAO;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.model.ListOfBuses;
@Service
public class ServiceBusTicket {
	@Autowired
	private BusTicketDAO busticket;

	// static Jdbi jdbi=ConnectionUtil.getJdbi();
	// static BusTicketDAO busticket=jdbi.onDemand(BusTicketDAO.class);
	void addBuslist(int busNo, String busName, String busSource, String busDestination, String clazz) throws Exception {
		busticket.addBuslist(busName, busSource, busDestination, clazz);
	}

	void deleteBuslist(int busNo) throws Exception {
		busticket.deleteBuslist(busNo);
	}

	int noOfBuses() throws Exception {
		return busticket.noOfBuses();
	}

	HashMap<String, Integer> noOfBuslist() throws Exception {
		return busticket.noOfBuslist();
	}

	public List<ListOfBuses> sourceStationlist(String busSource, String busDestination) throws ServiceException {

		List<ListOfBuses> sourceStationlist;
		try {
			validateSearch(busSource, busDestination);
			sourceStationlist = busticket.sourceStationlist(busSource, busDestination);
		} catch (DBException | ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return sourceStationlist;
	}

	public void validateSearch(String busSource, String busDestination) throws ValidatorException {
		if (busSource == null || busSource.equals("") || busSource.trim().equals("")) {
			throw new ValidatorException("Invalid Source");
		}
		if (busDestination == null) {
			throw new ValidatorException("Invalid destination");
		}
	}

}
