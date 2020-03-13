package com.chainsys.busticketapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.impl.BusTicketManagerImplimentation;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.ListOfBuses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class Buscontroller {

	BusTicketManagerImplimentation busimpl = new BusTicketManagerImplimentation();

	@PostMapping("/addbus")
	public void addBus(@RequestParam("busname") String busName, @RequestParam("source") String busSource,
			@RequestParam("destination") String busDestination, @RequestParam("class") String clazz) {

		try {
			busimpl.save(busName, busSource, busDestination, clazz);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/viewbus")
	public List<ListOfBuses> list(@RequestParam("source") String busSource,
			@RequestParam("destination") String busDestination) {
		List<ListOfBuses> source = null;
		try {
			source = busimpl.findBySourceDestination(busSource, busDestination);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return source;
	}

}
