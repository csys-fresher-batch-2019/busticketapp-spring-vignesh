package com.chainsys.busticketapp.validator;

import org.springframework.util.StringUtils;

import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.util.StringUtil;

public class UserValidator {

	public void validateSearch(String userName, String password) throws ValidatorException {
		/*
		 * if (StringUtil.isInvalidString(userName)) { throw new
		 * ValidatorException("Invalid UserName"); } if
		 * (StringUtil.isInvalidString(password)) { throw new
		 * ValidatorException("Invalid password"); }
		 */

		StringUtil.rejectIfInvalid(userName, "Invalid Username");
		StringUtil.rejectIfInvalid(password, "Invalid Password");

		StringUtils.hasText(userName);
	}

}
