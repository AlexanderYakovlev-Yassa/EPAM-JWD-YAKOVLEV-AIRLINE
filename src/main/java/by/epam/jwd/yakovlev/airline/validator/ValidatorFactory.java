package by.epam.jwd.yakovlev.airline.validator;

import by.epam.jwd.yakovlev.airline.validator.impl.*;

public class ValidatorFactory {
	
	private static ValidatorFactory INSTANCE = new ValidatorFactory();
	
	private EmployeeValidator employeeValidator = new EmployeeValidator();
	private PasswordValidator passwordValidator = new PasswordValidator();
	private AircraftValidator aircraftValidator = new AircraftValidator();
	private AircraftModelValidator aircraftModelValidator = new AircraftModelValidator();
	private AirportValidator airportValidator = new AirportValidator();
	private CrewRoleValidator crewRoleValidator = new CrewRoleValidator();
	private SystemRoleValidator systemRoleValidator = new SystemRoleValidator();
	private IDValidator idValidator = new IDValidator();
	private FlightValidator flightValidator = new FlightValidator();
	private DateTimeValidator dateTimeValidator = new DateTimeValidator();			
	
	private ValidatorFactory() {
		
	}

	public static ValidatorFactory getInstance() {
		return INSTANCE;
	}

	public EmployeeValidator getEmployeeValidator() {
		return employeeValidator;
	}


	public PasswordValidator getPasswordValidator() {
		return passwordValidator;
	}


	public AircraftValidator getAircraftValidator() {
		return aircraftValidator;
	}


	public AircraftModelValidator getAircraftModelValidator() {
		return aircraftModelValidator;
	}


	public AirportValidator getAirportValidator() {
		return airportValidator;
	}


	public CrewRoleValidator getCrewRoleValidator() {
		return crewRoleValidator;
	}


	public SystemRoleValidator getSystemRoleValidator() {
		return systemRoleValidator;
	}


	public IDValidator getIdValidator() {
		return idValidator;
	}


	public FlightValidator getFlightValidator() {
		return flightValidator;
	}

	public DateTimeValidator getDateTimeValidator() {
		return dateTimeValidator;
	}
}
