package com.chainsys.busticketapp.validator;

import com.chainsys.busticketapp.exception.ValidatorException;

public class UserValidator {

	public void validateSearch(String userName, String password) throws ValidatorException {
		if (userName == null || userName.equals("") || userName.trim().equals("")) {
			throw new ValidatorException("Invalid UserName");
		}
		if (password == null) {
			throw new ValidatorException("Invalid password");
		}
	}
}
