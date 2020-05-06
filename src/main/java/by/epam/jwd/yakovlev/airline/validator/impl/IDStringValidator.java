package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class IDStringValidator extends AbstractValidator{
	
	public void check(String idString) throws ValidatorException {
		
		checkNullOrEmptyString(idString);
		Integer id = null;
		try {
			id = Integer.parseInt(idString);
		} catch (NumberFormatException e) {
			throw new ValidatorException("The ID must be an integer nuber", e);
		}		
		checkNotNegativeInteger(id);
	}
}
