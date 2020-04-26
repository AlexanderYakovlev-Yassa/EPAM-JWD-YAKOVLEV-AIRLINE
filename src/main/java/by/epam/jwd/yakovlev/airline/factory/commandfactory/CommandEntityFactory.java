package by.epam.jwd.yakovlev.airline.factory.commandfactory;

import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandAircraftFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandAircraftModelFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandAirportFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandCrewRoleFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandDefaultEmployeeFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandEmployeeFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandFlightFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandSystemRoleFactory;

public class CommandEntityFactory {

	private final static CommandEntityFactory INSTANCE = new CommandEntityFactory();

	private CommandEntityFactory() {		
	}
	
	private CommandAircraftFactory aircraftFactory = new CommandAircraftFactory();
	private CommandAircraftModelFactory aircraftModelFactory = new CommandAircraftModelFactory();
	private CommandAirportFactory airportFactory = new CommandAirportFactory();
	private CommandCrewRoleFactory crewRoleFactory = new CommandCrewRoleFactory();
	private CommandEmployeeFactory employeeFactory = new CommandEmployeeFactory();
	private CommandFlightFactory flightFactory = new CommandFlightFactory();
	private CommandSystemRoleFactory systemRoleFactory = new CommandSystemRoleFactory();
	private CommandDefaultEmployeeFactory defaultEmployeeFactory = new CommandDefaultEmployeeFactory();

	public static CommandEntityFactory getInstance() {
		return INSTANCE;
	}
	public CommandAircraftFactory getAircraftFactory() {
		return aircraftFactory;
	}
	public CommandAircraftModelFactory getAircraftModelFactory() {
		return aircraftModelFactory;
	}
	public CommandAirportFactory getAirportFactory() {
		return airportFactory;
	}
	public CommandCrewRoleFactory getCrewRoleFactory() {
		return crewRoleFactory;
	}
	public CommandEmployeeFactory getEmployeeFactory() {
		return employeeFactory;
	}
	public CommandFlightFactory getFlightFactory() {
		return flightFactory;
	}
	public CommandSystemRoleFactory getSystemRoleFactory() {
		return systemRoleFactory;
	}
	public CommandDefaultEmployeeFactory getDefaultEmployeeFactory() {
		return defaultEmployeeFactory;
	}	
}
