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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class AbstractCommand {

	private static final Logger LOGGER = Logger.getLogger(AbstractCommand.class);
	private static final int ZERO = 0;
	private static final SimpleDateFormat DATE_SHORT_FORMAT = 
			new SimpleDateFormat(StringConstant.DATE_TIME_SHORT_FORMAT.getValue());

	private EmployeeService employeeService = ServiceFactory.INSTANCE.getEmployeeService();
	private FlightService flightService = ServiceFactory.INSTANCE.getFlightService();
	private AirportService airportService = ServiceFactory.INSTANCE.getAirportService();
	private AircraftService aircraftService = ServiceFactory.INSTANCE.getAircraftService();
	private AircraftModelService aircraftModelService = ServiceFactory.INSTANCE.getAircraftModelService();
	private SystemRoleService systemRoleService = ServiceFactory.INSTANCE.getSystemRoleService();
	private CrewRoleService crewRoleService = ServiceFactory.INSTANCE.getCrewRoleService();
	private CrewService crewService = ServiceFactory.INSTANCE.getCrewService();

	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;

	protected PageEnum getNextPage(HttpSession session) {

		try {
			return PageEnum
					.valueOf((((String) session.getAttribute(StringConstant.CURRENT_PAGE.getValue())).toUpperCase()));
		} catch (IllegalArgumentException | NullPointerException e) {
			return PageEnum.INDEX;
		}
	}

	protected void refreshAllEmployeesList(HttpSession session) {

		if (session == null) {
			return;
		}

		try {
			session.setAttribute(StringConstant.ALL_EMPLOYEE_LIST_KEY.getValue(),
					employeeService.getAllEmployeesList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all employees list", e);
		}
	}

	protected void refreshAllFlightsList(HttpSession session) {

		if (session == null) {
			return;
		}

		try {
			session.setAttribute(StringConstant.ALL_FLIGHTS_LIST_KEY.getValue(), flightService.getAllFlightsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all flights list", e);
		}
	}

	protected void refreshAllAircraftsList(HttpSession session) {

		if (session == null) {
			return;
		}

		try {
			session.setAttribute(StringConstant.ALL_AIRCRAFTS_LIST_KEY.getValue(),
					aircraftService.getAllAircraftsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all aircrafts list", e);
		}
	}

	protected void refreshAllAircraftModelsList(HttpSession session) {

		if (session == null) {
			return;
		}

		try {
			session.setAttribute(StringConstant.ALL_AIRCRAFT_MODELS_LIST_KEY.getValue(),
					aircraftModelService.getAllAircraftModelsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all aircraft modls list", e);
		}
	}

	protected void refreshAllAirportsList(HttpSession session) {

		if (session == null) {
			return;
		}

		try {
			session.setAttribute(StringConstant.ALL_AIRPORTS_LIST_KEY.getValue(), airportService.getAllAirportsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all aircrafts list", e);
		}
	}

	protected void refreshAllRolesList(HttpSession session) {

		if (session == null) {
			return;
		}

		try {
			session.setAttribute(StringConstant.ALL_SYSTEM_ROLE_LIST_KEY.getValue(),
					systemRoleService.getAllSystemRolesList());
			session.setAttribute(StringConstant.ALL_CREW_ROLE_LIST_KEY.getValue(),
					crewRoleService.getAllCrewRolesList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh all role lists", e);
		}
	}

	protected void refreshSelectedFlightCrew(HttpSession session) {

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

	protected int parseStringToIntOrElseZero(String intString) {

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

	protected void refreshTimePeriod(HttpSession session) {

		Object firstDateObject = session.getAttribute(StringConstant.FIRST_SELECTED_DATE.getValue());
		Object secondDateObject = session.getAttribute(StringConstant.SECOND_SELECTED_DATE.getValue());

		if (firstDateObject != null && secondDateObject != null) {
			return;
		}

		selectDefaultTimePeriod(session);
	}

	protected void selectDefaultTimePeriod(HttpSession session) {

		Date today = (new GregorianCalendar()).getTime();

		Date firstDate;
		Date secondDate;
		Flight youngestFlight = null;
		Flight oldestFlight = null;

		try {
			youngestFlight = flightService.getYoungestFlight().orElse(null);
			oldestFlight = flightService.getOldestFlight().orElse(null);
		} catch (ServiceException e) {
			LOGGER.debug("Fail get joungest of oldest flight");
		}

		firstDate = youngestFlight != null ? youngestFlight.getDepartureTime() : today;
		secondDate = oldestFlight != null ? oldestFlight.getDepartureTime() : today;

		session.setAttribute(StringConstant.FIRST_SELECTED_DATE.getValue(), firstDate);
		session.setAttribute(StringConstant.SECOND_SELECTED_DATE.getValue(), secondDate);
	}

	protected Date parseStringToDate(String string) {

		try {
			return DATE_SHORT_FORMAT.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}
}
