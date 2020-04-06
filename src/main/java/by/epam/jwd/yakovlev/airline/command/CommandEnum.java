package by.epam.jwd.yakovlev.airline.command;

import by.epam.jwd.yakovlev.airline.command.impl.*;

public enum CommandEnum {
    INITIALISE (new Initialise()),
    REFRESH_PAGE (new RefreshPage()),
    SET_LANGUAGE (new SetLanguage()),
    GOTO_PAGE_LOGIN (new GotoPageLogin()),
    GOTO_PAGE_AIRCRAFTS (new GotoPageAircrafts()),
    HOME (new Home()),
    LOGIN_USER (new LoginUser()),
    LOGOUT_USER (new Logout()),
    REGISTER_USER (new RegisterUser()),
    ADD_AIRCRAFT (new AddAircraft()),
    MANAGE_EMPLOYEES (new ManageEmployees());

    Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
