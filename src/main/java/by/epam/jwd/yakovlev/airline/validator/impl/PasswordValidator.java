package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class PasswordValidator extends AbstractValidator {

	
	public void check(char[] object) throws ValidatorException {
		
		checkObjectIsNotNull(object);
	}
}
