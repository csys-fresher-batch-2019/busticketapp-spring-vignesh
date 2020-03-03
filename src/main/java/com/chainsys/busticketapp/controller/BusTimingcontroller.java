package com.chainsys.busticketapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.impl.BusTimingIplementation;
import com.chainsys.busticketapp.model.BusTiming;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class BusTimingcontroller {
	BusTimingIplementation bustime = new BusTimingIplementation();
	@PostMapping("/addBusTime")
	public void addBusTiming(@RequestBody BusTiming u) throws Exception {
	
		 bustime.addBusTiming(u);	

	}

}
