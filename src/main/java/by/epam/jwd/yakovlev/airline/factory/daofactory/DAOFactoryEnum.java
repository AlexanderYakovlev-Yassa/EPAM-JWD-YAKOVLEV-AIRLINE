package by.epam.jwd.yakovlev.airline.factory.daofactory;

import by.epam.jwd.yakovlev.airline.factory.daofactory.impl.*;

public enum DAOFactoryEnum {
	AIRPORT (new DAOAirportFactory()),
	AIRCRAFT (new DAOAircraftFactory()),
	AIRCRAFT_MODEL (new DAOAircraftModelFactory()),
	CREW_ROLE (new DAOCrewRoleFactory()),
	EMPLOYEE (new DAOEmployeeFactory()),
	FLIGHT (new DAOFlightFactory()),
	SYSTEM_ROLE (new DAOSystemRoleFactory());
	
	AbstractDAOFactory<?> factory;

	private DAOFactoryEnum(AbstractDAOFactory<?> factory) {
		this.factory = factory;
	}

	public AbstractDAOFactory<?> getConcreatFactory() {
		return factory;
	}
}