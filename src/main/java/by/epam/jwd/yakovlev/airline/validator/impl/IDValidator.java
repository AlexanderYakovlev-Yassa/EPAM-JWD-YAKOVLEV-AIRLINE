package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class IDValidator extends AbstractValidator{
	
	public void check(Integer id) throws ValidatorException {
		
		checkNotNegativeInteger(id);
	}

}
