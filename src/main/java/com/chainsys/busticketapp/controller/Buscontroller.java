package com.chainsys.busticketapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.impl.BusDAOImplementation;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Buses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class Buscontroller {

	BusDAOImplementation busimpl = new BusDAOImplementation();

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
	public List<Buses> list(@RequestParam("source") String busSource,
			@RequestParam("destination") String busDestination) {
		List<Buses> source = null;
		try {
			source = busimpl.findBySourceDestination(busSource, busDestination);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return source;
	}
	@GetMapping("/viewbusdestination")
	public List<Buses> listDestination(@RequestParam("source") String busSource) {
		List<Buses> source = null;
		try {
			source = busimpl.findDestination(busSource);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return source;
	}

}
