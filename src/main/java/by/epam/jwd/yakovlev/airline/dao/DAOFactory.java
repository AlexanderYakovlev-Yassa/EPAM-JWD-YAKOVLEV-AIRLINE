package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.dao.impl.*;

public enum DAOFactory {

    INSTANCE;

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private final AircraftDAO aircraftDAO = new AircraftDAOImpl();
    private final AirportDAO airportDAO = new AirportDAOImpl();
    private final FlightDAO flightDAO = new FlightDaoImpl();

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public AircraftDAO getAircraftDAO() {
        return aircraftDAO;
    }
    
    public AirportDAO getAirportDAO() {
        return airportDAO;
    }

	public FlightDAO getFlightDAO() {
		return flightDAO;
	}
}
