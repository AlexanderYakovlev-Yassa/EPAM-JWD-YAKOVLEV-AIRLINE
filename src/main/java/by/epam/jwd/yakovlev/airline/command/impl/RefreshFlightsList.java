package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.FlightService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class RefreshFlightsList extends AbstractCommand {
	
	private static final Logger LOGGER = Logger.getLogger(RefreshFlightsList.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		LOGGER.debug("RefreshFlightsList starts");
		
		FlightService flightService = ServiceFactory.INSTANCE.getFlightService();
		
		HttpSession session = request.getSession();
		
		Date newFirstDate = parseStringToDate(request.getParameter(StringConstant.FIRST_DATE_KEY.getValue()));
		Date newSecondDate = parseStringToDate(request.getParameter(StringConstant.SECOND_DATE_KEY.getValue()));
		
		if (newFirstDate == null) {
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Wrong first date");
			return PageEnum.SELECT_FLIGHT.getPageURL();
		}
		
		if (newSecondDate == null) {
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Wrong second date");
			return PageEnum.SELECT_FLIGHT.getPageURL();
		}
		
		session.setAttribute(StringConstant.FIRST_SELECTED_DATE.getValue(), newFirstDate);
		session.setAttribute(StringConstant.SECOND_SELECTED_DATE.getValue(), newSecondDate);			
				
		try {			
			session.setAttribute(StringConstant.ALL_FLIGHTS_LIST_KEY.getValue(),
					flightService.getFlightsListBetweenDates(newFirstDate, newSecondDate));
		} catch (ServiceException e) {
			LOGGER.debug("Fail refresh the list of flights", e);
		}
		
		return PageEnum.SELECT_FLIGHT.getPageURL();
	}
}
