package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class AircraftValidator extends AbstractValidator {

	
	public void check(Aircraft aircraft) throws ValidatorException {

		checkNotNegativeInteger(aircraft.getAircraftID());	
		checkAircraftSideNumber(aircraft.getAircraftSideNumber());
		checkObjectIsNotNull(aircraft.getAircraftModel());
	}	
}