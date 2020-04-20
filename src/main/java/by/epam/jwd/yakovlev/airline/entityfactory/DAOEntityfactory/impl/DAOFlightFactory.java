package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOFlightFactory implements DAOEntityFactory{
	
	private static final Logger LOGGER = Logger.getLogger(DAOFlightFactory.class);
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat(StringConstant.DATE_TIME_FORMAT.getValue());

	@Override
	public Optional<Object> make(ResultSet resultSet) throws SQLException {
		
		int flightID = resultSet.getInt(StringConstant.FLIGHT_ID_KEY.getValue());
		Date departureTime = null;
		Date landingTime = null;		
		
		try {
			departureTime = DATE_FORMAT.parse(resultSet.getString(StringConstant.FLIGHT_DEPARTURE_TIME_KEY.getValue()));
			landingTime = DATE_FORMAT.parse(resultSet.getString(StringConstant.FLIGHT_LANDING_TIME_KEY.getValue()));			
		} catch (ParseException e) {
			LOGGER.debug("Wrong date time format");
		}
		
		int flightAircraftID = resultSet.getInt(StringConstant.FLIGHT_AIRCRAFT_ID_KEY.getValue());
		String flightAircraftSideNumber = resultSet.getString(StringConstant.FLIGHT_AIRCRAFT_SIDE_NUMBER_KEY.getValue());
		
		int flightAircraftModelID = resultSet.getInt(StringConstant.FLIGHT_AIRCRAFT_MODEL_ID_KEY.getValue());
		String flightAircraftModelName = resultSet.getString(StringConstant.FLIGHT_AIRCRAFT_MODEL_NAME_KEY.getValue());
		int flightAircraftModelCapacity = resultSet.getInt(StringConstant.FLIGHT_AIRCRAFT_MODEL_CAPACITY_KEY.getValue());
		
		int flightDepartureAirportID = resultSet.getInt(StringConstant.FLIGHT_DEPARTURE_AIRPORT_ID_KEY.getValue());
		String flightDepartureAirportCity = resultSet.getString(StringConstant.FLIGHT_DEPARTURE_AIRPORT_CITY_KEY.getValue());
		
		int flightDestinationAirportID = resultSet.getInt(StringConstant.FLIGHT_DESTINATION_AIRPORT_ID_KEY.getValue());
		String flightDestinationAirportCity = resultSet.getString(StringConstant.FLIGHT_DESTINATION_AIRPORT_CITY_KEY.getValue());
		
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
