package com.chainsys.busticketapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.impl.BookingDAOImplementation;
import com.chainsys.busticketapp.dto.Message;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.Booking;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class Bookingcontroller {

	BookingDAOImplementation book = new BookingDAOImplementation();

	@PostMapping("/addBooking")
	public ResponseEntity<?> addBusTiming(@RequestBody Booking u) {

		try {
			book.save(u);
			
		} catch (DBException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
}
