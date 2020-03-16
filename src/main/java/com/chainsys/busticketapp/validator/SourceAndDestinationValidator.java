package com.chainsys.busticketapp.validator;

import com.chainsys.busticketapp.exception.ValidatorException;

public class SourceAndDestinationValidator {

	public void validateSearch(String busSource, String busDestination) throws ValidatorException {
		if (busSource == null || busSource.equals("") || busSource.trim().equals("")) {
			throw new ValidatorException("Invalid Source");
		}
		if (busDestination == null || busDestination.equals("") || busDestination.trim().equals("")) {
			throw new ValidatorException("Invalid destination");
		}
	}
}
