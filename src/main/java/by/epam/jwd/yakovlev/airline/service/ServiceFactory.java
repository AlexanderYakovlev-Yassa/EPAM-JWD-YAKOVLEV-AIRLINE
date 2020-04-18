package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.service.impl.*;

public enum ServiceFactory {
    INSTANCE;

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private AircraftService aircraftService = new AircraftServiceImpl();
    private AirportService airportService = new AirportServiceImpl();

    public EmployeeService getEmployeeService() {
        return employeeService;
    }
    
    public AircraftService getAircraftService() {
        return aircraftService;
    }
    
    public AirportService getAirportService() {
        return airportService;
    }
}
