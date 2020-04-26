package by.epam.jwd.yakovlev.airline.factory.commandfactory;

import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.*;

public enum CommandEntityFactoryEnumDELETE {
	AIRCRAFT (new CommandAircraftFactory()),
	AIRCRAFT_MODEL (new CommandAircraftModelFactory()),
	AIRPORT (new CommandAirportFactory()),
	CREW_ROLE (new CommandCrewRoleFactory()),
	EMPLOYEE (new CommandEmployeeFactory()),
	FLIGHT (new CommandFlightFactory()),
	SYSTEM_ROLE (new CommandSystemRoleFactory());	
	
	AbstractCommandEntityFactory<?> factory;

	private CommandEntityFactoryEnumDELETE(AbstractCommandEntityFactory<?> factory) {
		this.factory = factory;
	}

	public AbstractCommandEntityFactory<?> getFactory() {
		return factory;
	}
}
