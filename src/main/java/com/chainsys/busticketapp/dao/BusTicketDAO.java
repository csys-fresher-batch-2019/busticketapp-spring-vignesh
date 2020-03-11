package com.chainsys.busticketapp.dao;

import java.util.HashMap;
import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.ListOfBuses;

public interface BusTicketDAO {
	
	//@SqlUpdate("insert into bus_list (bus_no,bus_name,bus_source,bus_destination,class)values(?,?,?,?,?)")
	void addBuslist(String busName, String busSource, String busDestination, String clazz) throws DBException;

	void deleteBuslist(int busNo) throws DBException;

	int noOfBuses() throws DBException;

	HashMap<String, Integer> noOfBuslist() throws DBException;
	
	public List<ListOfBuses> sourceStationlist(String busSource, String busDestination) throws DBException;
	
	}

