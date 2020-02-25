package com.chainsys.busticketapp.dao;

import java.util.HashMap;
import java.util.List;

import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.busticketapp.DBException;
import com.chainsys.busticketapp.model.ListOfBuses;

public interface BusTicketDAO {
	
	@SqlUpdate("insert into bus_list (bus_no,bus_name,bus_source,bus_destination,class)values(?,?,?,?,?)")
	void addBuslist(String busName, String busSource, String busDestination, String clazz) throws Exception;

	void deleteBuslist(int busNo) throws Exception;

	@SqlUpdate("select count(*) as busCount  from bus_list")
	int noOfBuses() throws Exception;
	
	@SqlUpdate("select bus_name,bus_no from bus_list")
	HashMap<String, Integer> noOfBuslist() throws Exception;
	
	@SqlUpdate("select *from bus_list where bus_source=? and bus_destination=?")
	public List<ListOfBuses> sourceStationlist(String busSource, String busDestination) throws DBException;
	
	//@SqlUpdate("select *from bus_list where bus_source=? and bus_destination=?")
	//public List<ListOfBuses> sourceStationlist(String busSource, String busDestination, LocalDate journeyDate) throws DBException;
}

