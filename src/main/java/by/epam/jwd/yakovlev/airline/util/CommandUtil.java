package by.epam.jwd.yakovlev.airline.util;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftModelService;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.service.CrewRoleService;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.FlightService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.service.SystemRoleService;

public class CommandUtil {

	private static CommandUtil INSTANCE = new CommandUtil();

	private Logger logger = Logger.getLogger(CommandUtil.class);
	private EmployeeService employeeService = ServiceFactory.INSTANCE.getEmployeeService();
	private FlightService flightService = ServiceFactory.INSTANCE.getFlightService();
	private AirportService airportService = ServiceFactory.INSTANCE.getAirportService();
	private AircraftService aircraftService = ServiceFactory.INSTANCE.getAircraftService();
	private AircraftModelService aircraftModelService = ServiceFactory.INSTANCE.getAircraftModelService();
	private SystemRoleService systemRoleService = ServiceFactory.INSTANCE.getSystemRoleService();
	private CrewRoleService crewRoleService = ServiceFactory.INSTANCE.getCrewRoleService();
	
	public CommandUtil() {
	}	

	public static CommandUtil getINSTANCE() {
		return INSTANCE;
	}

	public PageEnum getNextPage(HttpSession session) {

		try {
			return PageEnum
					.valueOf((((String) session.getAttribute(StringConstant.CURRENT_PAGE.getValue())).toUpperCase()));
		} catch (IllegalArgumentException | NullPointerException e) {
			return PageEnum.INDEX;
		}
	}

	public void refreshAllEmployeesList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_EMPLOYEE_LIST_KEY.getValue(), employeeService.getAllEmployeesList());
		} catch (ServiceException e) {
			logger.debug("Fail refresh all employees list", e);
		}
	}
	
	public void refreshAllFlightsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_FLIGHTS_LIST_KEY.getValue(), flightService.getAllFlightsList());
		} catch (ServiceException e) {
			logger.debug("Fail refresh all flights list", e);
		}
	}
	
	public void refreshAllAircraftsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_AIRCRAFTS_LIST_KEY.getValue(), aircraftService.getAllAircraftsList());
		} catch (ServiceException e) {
			logger.debug("Fail refresh all aircrafts list", e);
		}
	}
	
	public void refreshAllAircraftModelsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_AIRCRAFT_MODELS_LIST_KEY.getValue(), aircraftModelService.getAllAircraftModelsList());
		} catch (ServiceException e) {
			logger.debug("Fail refresh all aircraft modls list", e);
		}
	}
	
	public void refreshAllAirportsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_AIRPORTS_LIST_KEY.getValue(), airportService.getAllAirportsList());
		} catch (ServiceException e) {
			logger.debug("Fail refresh all aircrafts list", e);
		}
	}
	
	public void refreshAllRolesList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_SYSTEM_ROLE_LIST_KEY.getValue(), systemRoleService.getAllSystemRolesList());
			session.setAttribute(StringConstant.ALL_CREW_ROLE_LIST_KEY.getValue(), crewRoleService.getAllCrewRolesList());
		} catch (ServiceException e) {
			logger.debug("Fail refresh all role lists", e);
		}
	}
}
