package com.chainsys.busticketapp.util;

import java.util.HashMap;
import java.util.List;

import com.chainsys.busticketapp.DBException;
import com.chainsys.busticketapp.dao.BusTicketDAO;
import com.chainsys.busticketapp.dao.impl.BusTicketManagerImplimentation;
import com.chainsys.busticketapp.model.ListOfBuses;

public class ServiceBusTicket {

	private BusTicketDAO busticket = new BusTicketManagerImplimentation();
	//static Jdbi jdbi=ConnectionUtil.getJdbi();
	//static BusTicketDAO busticket=jdbi.onDemand(BusTicketDAO.class);
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
