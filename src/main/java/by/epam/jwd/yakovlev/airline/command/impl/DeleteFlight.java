package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandFlightFactory;
import by.epam.jwd.yakovlev.airline.service.FlightService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.CommandUtil;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DeleteFlight implements Command{
	
	private static final Logger LOGGER = Logger.getLogger(DeleteFlight.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
		Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();
		FlightService service = ServiceFactory.INSTANCE.getFlightService();
		CommandFlightFactory factory = CommandEntityFactory.getInstance().getFlightFactory();
		CommandUtil util = CommandUtil.getINSTANCE();
		
		Flight flight = null;
		
		try {
			flight = factory.create(map);
			service.deleteFlight(flight);
			util.refreshAllFlightsList(session);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "The flight deleted successfully");
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("Fail update the flight", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail delete the flight.");
			return PageEnum.FLIGHTS_MANAGEMENT.getPageURL();
		}
		
		return PageEnum.FLIGHTS_MANAGEMENT.getPageURL();
	}
}
