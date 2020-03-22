package by.epam.jwd.yakovlev.airline.command;

import by.epam.jwd.yakovlev.airline.command.impl.CommandImpl;

public enum CommandFactory {
    INSTANCE;

    private static Command command = new CommandImpl();

    public Command getCommand() {
        return command;
    }
}
