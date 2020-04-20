package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandFlightFactory implements CommandEntityFactory{
	
	private static final Logger LOGGER = Logger.getLogger(CommandFlightFactory.class);
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat(StringConstant.DATE_TIME_FORMAT.getValue());
	private static final int ZERO_INDEX = 0;

	@Override
	public Optional<Object> create(Map<String, String[]> map) throws EntityFactoryException {
		
		int flightID = parseToPositiveIntOrElseZero(map.get(StringConstant.FLIGHT_ID_KEY.getValue())[ZERO_INDEX]);
		Date departureTime = null;
		Date landingTime = null;		
		
		try {
			departureTime = DATE_FORMAT.parse
					(map.get(StringConstant.FLIGHT_DEPARTURE_TIME_KEY.getValue())[ZERO_INDEX]);
			landingTime = DATE_FORMAT.parse
					(map.get(StringConstant.FLIGHT_LANDING_TIME_KEY.getValue())[ZERO_INDEX]);
		} catch (ParseException e) {
			LOGGER.debug("Wrong date time format");			
		}
		
		int flightAircraftID = parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_AIRCRAFT_ID_KEY.getValue())[ZERO_INDEX]);
		
		String flightAircraftSideNumber = map.get
				(StringConstant.FLIGHT_AIRCRAFT_SIDE_NUMBER_KEY.getValue())[ZERO_INDEX];
		
		int flightAircraftModelID = parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_AIRCRAFT_MODEL_ID_KEY.getValue())[ZERO_INDEX]);
		
		String flightAircraftModelName = map.get
				(StringConstant.FLIGHT_AIRCRAFT_MODEL_NAME_KEY.getValue())[ZERO_INDEX];
		
		int flightAircraftModelCapacity =  parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_AIRCRAFT_MODEL_CAPACITY_KEY.getValue())[ZERO_INDEX]);
		
		int flightDepartureAirportID = parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_DEPARTURE_AIRPORT_ID_KEY.getValue())[ZERO_INDEX]);
		
		String flightDepartureAirportCity = map.get
				(StringConstant.FLIGHT_DEPARTURE_AIRPORT_CITY_KEY.getValue())[ZERO_INDEX];
		
		int flightDestinationAirportID = parseToPositiveIntOrElseZero
				(map.get(StringConstant.FLIGHT_DESTINATION_AIRPORT_ID_KEY.getValue())[ZERO_INDEX]);
		
		String flightDestinationAirportCity = 
				map.get(StringConstant.FLIGHT_DESTINATION_AIRPORT_CITY_KEY.getValue())[ZERO_INDEX];
		
		AircraftModel aircraftModel = new AircraftModel(flightAircraftModelID, flightAircraftModelName, flightAircraftModelCapacity);
		
		Aircraft aircraft = new Aircraft(flightAircraftID, flightAircraftSideNumber, aircraftModel);
		
		Airport departureAirport = new Airport(flightDepartureAirportID, flightDepartureAirportCity);
		
		Airport destinationAirport = new Airport(flightDestinationAirportID, flightDestinationAirportCity);
		
		Flight flight = new Flight();
		
		flight.setFlightID(flightID);
		flight.setDepartureTime(departureTime);
		flight.setLandingTime(landingTime);
		flight.setAircraft(aircraft);
		flight.setDepartureAirport(departureAirport);
		flight.setDestinationAirport(destinationAirport);
		
		return Optional.of(flight);
	}
}
