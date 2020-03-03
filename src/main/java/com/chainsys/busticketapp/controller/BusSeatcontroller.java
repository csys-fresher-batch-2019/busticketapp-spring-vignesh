package com.chainsys.busticketapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.impl.SeatAvailabilityimplementation;
import com.chainsys.busticketapp.model.SeatAvailability;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class BusSeatcontroller {
	SeatAvailabilityimplementation seat= new SeatAvailabilityimplementation();
	@PostMapping("/addseat")
	public void addAvailableSeatlist(@RequestBody SeatAvailability obj) {
		try {
			seat.addAvailableSeatlist(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
