package by.epam.jwd.yakovlev.airline.validator;

import by.epam.jwd.yakovlev.airline.validator.impl.*;

public enum ValidatorsEnum {
EMPLOYEE_VALIDATOR (new EmployeeValidator()),/*
SYSTEM_ROLE_VALIDATOR,
CREW_ROLE_VALIDATOR,*/
AIRCRAFT_MODEL_VALIDATOR (new AircraftModelValidator()),
AIRCRAFT_VALIDATOR (new AircraftValidator()),
AIRPORT_VALIDATOR (new AirportValidator()),
FLIGHT_VALIDATOR (new FlightValidator());
	
	Validator validator;

	private ValidatorsEnum(Validator validator) {
		this.validator = validator;
	}

	public Validator getValidator() {
		return validator;
	}
}
