package com.chainsys.busticketapp.dao;

import java.util.HashMap;
import java.util.List;

import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Buses;

public interface BusDAO {
	
	//@SqlUpdate("insert into bus_list (bus_no,bus_name,bus_source,bus_destination,class)values(?,?,?,?,?)")
	void save(String busName, String busSource, String busDestination, String clazz) throws DBException;

	//void delete(int busNo) throws DBException;

	int count() throws DBException;

	HashMap<String, Integer> findAllByBusName() throws DBException;
	
	public List<Buses> findBySourceDestination(String busSource, String busDestination) throws DBException;
	
	public List<Buses> findDestination(String busSource) throws DBException;
	}

