package by.epam.jwd.yakovlev.airline.command;

import by.epam.jwd.yakovlev.airline.command.impl.*;

public enum CommandEnum {
    ADD_AIRPORT (new AddAirport(), 0),
    ADD_AIRCRAFT (new AddAircraft(), 0),
    ADD_AIRCRAFT_MODEL (new AddAircraftModel(), 0),
    ADD_EMPLOYEE (new AddEmployee(), 0),
    ADD_EMPLOYEE_TO_CREW (new AddEmployeeToCrew(), 1),
    ADD_FLIGHT (new AddFlight(), 0),
    CHANGE_PASSWORD (new UpdatePassword(), 0),
    DELETE_EMPLOYEE (new DeleteEmployee(), 0),
    DELETE_AIRPORT (new DeleteAirport(), 0),
    DELETE_AIRCRAFT (new DeleteAircraft(), 0),
    DELETE_AIRCRAFT_MODEL (new DeleteAircraftModel(), 0),
    DELETE_FLIGHT (new DeleteFlight(), 0),
    GOTO_PAGE_CABINET (new GotoCabinetPage(), 2),
    GOTO_PAGE_AIRCRAFT_MANAGEMENT (new GotoPageAircraftManagement(), 0),
    GOTO_PAGE_AIRCRAFT_MODELS_MANAGEMENT (new GotoPageAircraftModelsManagement(), 0),
    GOTO_PAGE_AIRPORTS_MANAGEMENT (new GotoPageAirportsManagement(), 0),
    GOTO_PAGE_FLIGHTS_MANAGEMENT (new GotoPageFlightsManagement(), 0),
    GOTO_PAGE_FLIGHT_SCHEDULE (new GotoPageFlightSchedule(), 3),
    GOTO_PAGE_UNRECOGNIZED_COMMAND (new UnrecognizedCommandPage(), 3),
    GOTO_PAGE_SELECT_CREW (new GotoSelectCrewPage(), 1),
    HOME (new Home(), 3),
    INITIALISE_SESSION (new Initialise(), 3),
    LOGIN_USER (new LoginUser(), 3),
    LOGOUT_USER (new Logout(), 3),
    MANAGE_EMPLOYEES (new ManageEmployees(), 0),
    REMOVE_CREW_MEMBER (new RemoveEmployeeFromCrew(), 1),
    SELECT_FLIGHT_BY_ID (new SelectFlightByID(), 3),
    SET_LANGUAGE (new SetLanguage(), 3),
    UPDATE_EMPLOYEE (new UpdateEmployee(), 2),
    UPDATE_AIRPORT (new UpdateAirport(), 0),
    UPDATE_AIRCRAFT (new UpdateAircraft(), 0),
    UPDATE_AIRCRAFT_MODEL (new UpdateAircraftModel(), 0),
    UPDATE_FLIGHT (new UpdateFlight(), 0);

    Command command;
    int securityIndex;

    CommandEnum(Command command, int securityIndex) {
        this.command = command;
        this.securityIndex = securityIndex;
    }

    public Command getCommand() {
        return command;
    }
    
    public int getSecurityIndex() {
    	return securityIndex;
    }
}
