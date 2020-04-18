package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory;

import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl.*;

public enum DAOEntityType {
    AIRCRAFT (new DAOAircraftFactory()),
    AIRCRAFT_MODEL (new DAOAircraftModelFactory()),
    AIRPORT (new DAOAirportFactory()),
    /*CREW (new DAOCrewFactory()),*/
    CREW_ROLE (new DAOCrewRoleFactory()),
    EMPLOYEE (new DAOEmployeeFactory()),/*
    FLIGHT (new DAOFlightFactory()),*/
    SYSTEM_ROLE (new DAOSystemRoleFactory());

    private DAOEntityFactory entityFactory;

    DAOEntityType(DAOEntityFactory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public DAOEntityFactory getEntityFactory() {
        return entityFactory;
    }
}