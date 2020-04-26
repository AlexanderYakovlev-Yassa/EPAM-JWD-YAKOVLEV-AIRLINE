package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.dao.impl.*;

public class DAOFactory {
	
	private static final DAOFactory INSTANCE = new DAOFactory();
	
	private AircraftDAO aircraftDAO = new AircraftDAOImpl();
	private AircraftModelDAO aircraftModelDAO = new AircraftModelDAOImpl();
	private AirportDAO airportDAO = new AirportDAOImpl();
	private CrewRoleDAO crewRoleDAO = new CrewRoleDAOImpl();
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	private FlightDAO flightDAO = new FlightDAOImpl();
	private SystemRoleDAO systemRoleDAO = new SystemRoleDAOImpl();
	
	private DAOFactory() {
		
	}

	public static DAOFactory getInstance() {
		return INSTANCE;
	}

	public AircraftDAO getAircraftDAO() {
		return aircraftDAO;
	}

	public AircraftModelDAO getAircraftModelDAO() {
		return aircraftModelDAO;
	}

	public AirportDAO getAirportDAO() {
		return airportDAO;
	}

	public CrewRoleDAO getCrewRoleDAO() {
		return crewRoleDAO;
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public FlightDAO getFlightDAO() {
		return flightDAO;
	}

	public SystemRoleDAO getSystemRoleDAO() {
		return systemRoleDAO;
	}
}
