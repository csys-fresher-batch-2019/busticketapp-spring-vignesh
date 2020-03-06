package com.chainsys.busticketapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PostMapping("/updateseat")
	public void updateAvailableSeatlist(int availableSeats, int busNo) throws Exception {
	
		seat.updateAvailableSeatlist(availableSeats, busNo);
	}
	@GetMapping("/viewseat")
	public int availableSeatDetails(int busNo) throws Exception {
		 int seats=seat.availableSeatDetails(busNo);
		return seats;
		
	}
}
