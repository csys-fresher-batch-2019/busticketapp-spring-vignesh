package com.chainsys.busticketapp.util;

import org.springframework.util.StringUtils;

import com.chainsys.busticketapp.exception.ValidatorException;

public class StringUtil {

	public static boolean isInvalidString(String input) {
		boolean result = StringUtils.hasText(input);
		return result;
	}

	public static void rejectIfInvalid(String input, String message) throws ValidatorException {
		if (input == null || input.equals("") || input.trim().equals("")) {
			throw new ValidatorException(message);
		}
	}
}
