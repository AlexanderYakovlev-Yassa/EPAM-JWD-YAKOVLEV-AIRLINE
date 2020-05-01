package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.service.impl.*;

public enum ServiceFactory {
    INSTANCE;

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private AircraftService aircraftService = new AircraftServiceImpl();
    private AirportService airportService = new AirportServiceImpl();
    private FlightService flightService = new FlightServiceImpl();
    private SystemRoleService systemRoleService = new  SystemRoleServiceImpl();
    private CrewRoleService crewRoleService = new CrewRoleServiceImpl();
    private CrewService crewService = new CrewServiceImpl();
    private AircraftModelService aircraftModelService = new AircraftModelServiceImpl();

    public EmployeeService getEmployeeService() {
        return employeeService;
    }
    
    public AircraftService getAircraftService() {
        return aircraftService;
    }
    
    public AirportService getAirportService() {
        return airportService;
    }

	public FlightService getFlightService() {
		return flightService;
	}

	public SystemRoleService getSystemRoleService() {
		return systemRoleService;
	}

	public CrewRoleService getCrewRoleService() {
		return crewRoleService;
	}

	public AircraftModelService getAircraftModelService() {
		return aircraftModelService;
	}

	public CrewService getCrewService() {
		return crewService;
	}	
}
