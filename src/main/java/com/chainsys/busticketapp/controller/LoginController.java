package com.chainsys.busticketapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.impl.LoginDAOImplementation;
import com.chainsys.busticketapp.exception.DBException;
import com.chainsys.busticketapp.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class LoginController {
	LoginDAOImplementation login = new LoginDAOImplementation();

	@GetMapping("/userlogin")
	public User userLogin(@RequestParam("email") String emailId, @RequestParam("password") String password) {
		User u = null;
		try {
			u = login.userLogin(emailId, password);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return u;

	}
}
