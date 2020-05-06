package by.epam.jwd.yakovlev.airline.factory.daofactory;

import by.epam.jwd.yakovlev.airline.factory.daofactory.impl.*;

public enum DAOFactoryEnum {
	AIRPORT (new DAOAirportFactory()),
	AIRPORTS_LIST (new DAOAirportsListFactory()),
	AIRCRAFT (new DAOAircraftFactory()),
	AIRCRAFTS_LIST (new DAOAircraftsListFactory()),
	AIRCRAFT_MODEL (new DAOAircraftModelFactory()),
	AIRCRAFT_MODELS_LIST (new DAOAircraftModelsListFactory()),
	CREW_ROLE (new DAOCrewRoleFactory()),
	CREW_ROLES_LIST (new DAOCrewRolesListFactory()),
	CREW (new DAOCrewFactory()),
	EMPLOYEE (new DAOEmployeeFactory()),
	EMPLOYEES_LIST (new DAOEmployeesListFactory()),
	FLIGHT (new DAOFlightFactory()),
	FLIGHTS_LIST (new DAOFlightsListFactory()),
	SYSTEM_ROLE (new DAOSystemRoleFactory()),
	SYSTEM_ROLES_LIST (new DAOSystemRolesListFactory());
	
	AbstractDAOFactory<?> factory;

	private DAOFactoryEnum(AbstractDAOFactory<?> factory) {
		this.factory = factory;
	}

	public AbstractDAOFactory<?> getConcreatFactory() {
		return factory;
	}
}