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
import com.chainsys.busticketapp.validator.SourceDestinationValidator;
@Service
public class BusTicketService {
	@Autowired
	private BusTicketDAO busticket;

	// static Jdbi jdbi=ConnectionUtil.getJdbi();
	// static BusTicketDAO busticket=jdbi.onDemand(BusTicketDAO.class);
	public void addBuslist(int busNo, String busName, String busSource, String busDestination, String clazz) throws Exception {
		busticket.save(busName, busSource, busDestination, clazz);
	}

	/*void deleteBuslist(int busNo) throws Exception {
		busticket.deleteBuslist(busNo);
	}
*/
	public int noOfBuses() throws Exception {
		return busticket.count();
	}

	HashMap<String, Integer> noOfBuslist() throws Exception {
		return busticket.findAllByBusName();
	}

	public List<ListOfBuses> sourceStationlist(String busSource, String busDestination) throws ServiceException {

		List<ListOfBuses> sourceStationlist;
		try {
			SourceDestinationValidator sourceValidator = new SourceDestinationValidator();
			sourceValidator.validateSearch(busSource, busDestination);
			sourceStationlist = busticket.findBySourceDestination(busSource, busDestination);
		} catch (DBException | ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return sourceStationlist;
	}

	

}
