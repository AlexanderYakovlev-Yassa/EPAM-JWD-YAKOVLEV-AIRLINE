package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory;

import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl.*;

public enum EntityFactoryTypesEnum {
    AIRCRAFT (new CommandAircraftFactory()),
    AIRCRAFT_MODEL (new CommandAircraftModelFactory()),
    AIRPORT (new CommandAirportFactory()),
 /*   CREW (new CommandCrewFactory()),
    CREW_ROLE (new CommandCrewRoleFactory()),*/
    EMPLOYEE (new CommandEmployeeFactory())/*,
    FLIGHT (new CommandFlightFactory()),
    SYSTEM_ROLE (new CommandSystemRoleFactory())*/;

    private CommandEntityFactory concreatEntityFactory;

	private EntityFactoryTypesEnum(CommandEntityFactory entityFactory) {
		this.concreatEntityFactory = entityFactory;
	}

	public CommandEntityFactory getConcreatEntityFactory() {
        return concreatEntityFactory;
    }
}