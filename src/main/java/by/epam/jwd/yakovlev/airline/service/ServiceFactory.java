package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.service.impl.*;

public enum ServiceFactory {
    INSTANCE;

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private AircraftService aircraftService = new AircraftServiceImpl();

    public EmployeeService getEmployeeService() {
        return employeeService;
    }
    
    public AircraftService getAircraftService() {
        return aircraftService;
    }
}
