package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.AbstractCommandEntityFactory;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandFlightFactory extends AbstractCommandEntityFactory<Flight>{
	
	private static final Logger LOGGER = Logger.getLogger(CommandFlightFactory.class);
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat(StringConstant.DATE_TIME_SHORT_FORMAT.getValue());
	private static final int ZERO_INDEX = 0;
	
	@Override
	public Flight create(Map<String, String[]> map) throws EntityFactoryException {
		
		int flightID = parseToPositiveIntOrElseZero(map.get(StringConstant.FLIGHT_ID_KEY.getValue())[ZERO_INDEX]);
		Date departureTime = null;
		Date landingTime = null;
		
		try {
			departureTime = DATE_FORMAT.parse
					(map.get(StringConstant.FLIGHT_DEPARTURE_TIME_KEY.getValue())[ZERO_INDEX]);
			landingTime = DATE_FORMAT.parse
					(map.get(StringConstant.FLIGHT_LANDING_TIME_KEY.getValue())[ZERO_INDEX]);
		} catch (ParseException e) {
			LOGGER.debug("Wrong date time format", e);			
		}
		
		int flightAircraftID = parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_AIRCRAFT_ID_KEY.getValue())[ZERO_INDEX]);
		
		int flightDepartureAirportID = parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_DEPARTURE_AIRPORT_ID_KEY.getValue())[ZERO_INDEX]);
		
		int flightDestinationAirportID = parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_DESTINATION_AIRPORT_ID_KEY.getValue())[ZERO_INDEX]);
		
		Flight flight = new Flight();
		
		flight.setFlightID(flightID);
		flight.setDepartureTime(departureTime);
		flight.setLandingTime(landingTime);
		
		try {
			ServiceFactory.INSTANCE.getAircraftService().getAircraftByID(flightAircraftID).ifPresent(flight::setAircraft);
			ServiceFactory.INSTANCE.getAirportService().getAirportByID(flightDepartureAirportID).ifPresent(flight::setDepartureAirport);
			ServiceFactory.INSTANCE.getAirportService().getAirportByID(flightDestinationAirportID).ifPresent(flight::setDestinationAirport);
		} catch (ServiceException e) {
			LOGGER.debug("Fail get flight components", e);			
		}				
		
		LOGGER.debug(flight.getDepartureTime());
		LOGGER.debug(flight.getLandingTime());	
		LOGGER.debug(flight.getDepartureAirport());
		LOGGER.debug(flight.getDestinationAirport());
		LOGGER.debug(flight.getAircraft());
		
		return flight;
	}
}
