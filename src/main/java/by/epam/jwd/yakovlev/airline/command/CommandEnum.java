package by.epam.jwd.yakovlev.airline.command;

import by.epam.jwd.yakovlev.airline.command.impl.*;

public enum CommandEnum {
    INITIALISE (new Initialise()),
    SET_LANGUAGE (new SetLanguage()),
    HOME (new Home()),
    LOGIN_USER (new LoginUser()),
    LOGOUT_USER (new Logout()),
    ADD_AIRPORT (new AddAirport()),
    ADD_AIRCRAFT (new AddAircraft()),
    ADD_AIRCRAFT_MODEL (new AddAircraftModel()),
    ADD_EMPLOYEE (new AddEmployee()),
    ADD_FLIGHT (new AddFlight()),
    DELETE_EMPLOYEE (new DeleteEmployee()),
    DELETE_AIRPORT (new DeleteAirport()),
    DELETE_AIRCRAFT (new DeleteAircraft()),
    DELETE_AIRCRAFT_MODEL (new DeleteAircraftModel()),
    DELETE_FLIGHT (new DeleteFlight()),
    MANAGE_EMPLOYEES (new ManageEmployees()),
    GOTO_PAGE_CABINET (new GotoCabinetPage()),
    GOTO_PAGE_AIRCRAFT_MANAGEMENT (new GotoPageAircraftManagement()),
    GOTO_PAGE_AIRCRAFT_MODELS_MANAGEMENT (new GotoPageAircraftModelsManagement()),
    GOTO_PAGE_AIRPORTS_MANAGEMENT (new GotoPageAirportsManagement()),
    GOTO_PAGE_FLIGHTS_MANAGEMENT (new GotoPageFlightsManagement()),
    CHANGE_PASSWORD (new UpdatePassword()),
    UPDATE_EMPLOYEE (new UpdateEmployee()),
    UPDATE_AIRPORT (new UpdateAirport()),
    UPDATE_AIRCRAFT (new UpdateAircraft()),
    UPDATE_AIRCRAFT_MODEL (new UpdateAircraftModel()),
    UPDATE_FLIGHT (new UpdateFlight());

    Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
