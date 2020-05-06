package by.epam.jwd.yakovlev.airline.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Crew;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftModelService;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.service.CrewRoleService;
import by.epam.jwd.yakovlev.airline.service.CrewService;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.FlightService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.service.SystemRoleService;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.io.IOException;

public abstract class AbstractCommand {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractCommand.class);
	private static final int ZERO = 0;	
	
	private EmployeeService employeeService = ServiceFactory.INSTANCE.getEmployeeService();
	private FlightService flightService = ServiceFactory.INSTANCE.getFlightService();
	private AirportService airportService = ServiceFactory.INSTANCE.getAirportService();
	private AircraftService aircraftService = ServiceFactory.INSTANCE.getAircraftService();
	private AircraftModelService aircraftModelService = ServiceFactory.INSTANCE.getAircraftModelService();
	private SystemRoleService systemRoleService = ServiceFactory.INSTANCE.getSystemRoleService();
	private CrewRoleService crewRoleService = ServiceFactory.INSTANCE.getCrewRoleService();
	private CrewService crewService = ServiceFactory.INSTANCE.getCrewService();

    public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
    
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
			LOGGER.debug("Fail refresh all employees list", e);
		}
	}
	
	public void refreshAllFlightsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_FLIGHTS_LIST_KEY.getValue(), flightService.getAllFlightsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all flights list", e);
		}
	}
	
	public void refreshAllAircraftsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_AIRCRAFTS_LIST_KEY.getValue(), aircraftService.getAllAircraftsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all aircrafts list", e);
		}
	}
	
	public void refreshAllAircraftModelsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_AIRCRAFT_MODELS_LIST_KEY.getValue(), aircraftModelService.getAllAircraftModelsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all aircraft modls list", e);
		}
	}
	
	public void refreshAllAirportsList(HttpSession session) {

		if (session == null) {
			return;
		}
		
		try {
			session.setAttribute(StringConstant.ALL_AIRPORTS_LIST_KEY.getValue(), airportService.getAllAirportsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all aircrafts list", e);
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
			LOGGER.debug("Fail refresh all role lists", e);
		}
	}
	
	public void refreshSelectedFlightCrew(HttpSession session) {

		if (session == null) {
			return;
		}
		
		if (session.getAttribute(StringConstant.SELECTED_FLIGHT_KEY.getValue()) != null) {
			Flight selectedFlight = (Flight) session.getAttribute(StringConstant.SELECTED_FLIGHT_KEY.getValue());
			if (selectedFlight != null) {
				try {
					Crew crew = crewService.getCrewByFlightID(selectedFlight.getFlightID());
					session.setAttribute(StringConstant.SELECTED_FLIGHT_CREW_KEY.getValue(), crew);
				} catch (ServiceException e) {
					LOGGER.debug("Fail get crew");
				}
			}
		}
	}
	
	public int parseStringToIntOrElseZero(String intString) {
		
		int integer = ZERO;
		
		if (intString == null) {
			return integer;
		}
		
		try {
			integer = Integer.parseInt(intString);
		} catch (NumberFormatException e) {
			integer = ZERO;
		}
		
		return integer;
	}
}
