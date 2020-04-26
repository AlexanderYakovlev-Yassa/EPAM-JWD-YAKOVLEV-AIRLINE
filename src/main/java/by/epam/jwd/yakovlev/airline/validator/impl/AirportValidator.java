package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class AirportValidator extends AbstractValidator{

	
	public void check(Airport airport) throws ValidatorException {
		
		checkNotNegativeInteger(airport.getAirportID());
		checkWord(airport.getAirportCity());
	}
}
