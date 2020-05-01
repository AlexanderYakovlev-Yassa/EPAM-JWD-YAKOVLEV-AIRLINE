package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.FlightService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class SelectFlightByID extends Command{
	
	private static final Logger LOGGER = Logger.getLogger(SelectFlightByID.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		FlightService flightService = ServiceFactory.INSTANCE.getFlightService();
		
		
		int flightID = parseStringToIntOrElseZero(request.getParameter(StringConstant.FLIGHT_ID_KEY.getValue()));
		
		try {
			flightService.getFlightByID(flightID)
			.ifPresent(f -> session.setAttribute(StringConstant.SELECTED_FLIGHT_KEY.getValue(), f));
		} catch (ServiceException e) {
			LOGGER.debug("Fail select flight");
		}
		
		refreshSelectedFlightCrew(session);
		
		return getNextPage(session).getPageURL();
	}
}
