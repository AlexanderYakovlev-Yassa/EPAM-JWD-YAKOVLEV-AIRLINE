package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.EntityFactoryTypesEnum;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;

public class UpdateAirport implements Command{

	private static final Logger LOGGER = Logger.getLogger(UpdateAirport.class);
	private static final CommandEntityFactory AIRPORT_FACTORY = EntityFactoryTypesEnum.AIRPORT.getConcreatEntityFactory();
	private static final AirportService AIRPORT_SERVICE = ServiceFactory.INSTANCE.getAirportService();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();

		Optional<Object> airportOptional = Optional.empty();

		try {
			airportOptional = AIRPORT_FACTORY.create(map);
		} catch (EntityFactoryException e) {			
			LOGGER.debug("Fail create an airport because " + e.getMessage());
			session.setAttribute("warning_message", "Fail execute such updates.");
			return PageEnum.AIRPORT_MANAGEMENT.getPageURL();
		}
		
		try {
			AIRPORT_SERVICE.updateAirport(airportOptional);
			session.setAttribute("success_message", "The airport was updated successfully");
            session.setAttribute("all_airports_list", AIRPORT_SERVICE.getAllAirportList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail update the airport because " + e.getMessage());
			session.setAttribute("warning_message", "Fail update airport.");
		}
		
		return PageEnum.AIRPORT_MANAGEMENT.getPageURL();
	}
}
