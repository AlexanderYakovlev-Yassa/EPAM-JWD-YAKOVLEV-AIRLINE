package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class AircraftModelValidator extends AbstractValidator{

	public void check(AircraftModel aircraftModel) throws ValidatorException {

		checkNotNegativeInteger(aircraftModel.getAircraftModelID());
		checkNotNegativeInteger(aircraftModel.getAircraftModelCapacity());		
	}
}