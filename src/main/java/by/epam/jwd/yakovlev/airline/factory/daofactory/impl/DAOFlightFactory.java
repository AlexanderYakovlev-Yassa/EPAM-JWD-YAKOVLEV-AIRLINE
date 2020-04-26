package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOFlightFactory extends AbstractDAOFactory<Flight> {
	
	private static final Logger LOGGER = Logger.getLogger(DAOFlightFactory.class);
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat(StringConstant.DATE_TIME_LONG_FORMAT.getValue());
	
	public Flight create(ResultSet resultSet) throws SQLException {

		Date departureTime = null;
		Date landingTime = null;		
		
		try {
			departureTime = DATE_FORMAT.parse(resultSet.getString(StringConstant.FLIGHT_DEPARTURE_TIME_KEY.getValue()));
			landingTime = DATE_FORMAT.parse(resultSet.getString(StringConstant.FLIGHT_LANDING_TIME_KEY.getValue()));			
		} catch (ParseException e) {
			LOGGER.debug("Wrong date time format", e);
		}		
		
		AircraftModel aircraftModel = new AircraftModel();
		aircraftModel.setAircraftModelID(resultSet.getInt(StringConstant.FLIGHT_AIRCRAFT_MODEL_ID_KEY.getValue()));
		aircraftModel.setAircraftModelName(resultSet.getString(StringConstant.FLIGHT_AIRCRAFT_MODEL_NAME_KEY.getValue()));
		aircraftModel.setAircraftModelCapacity(resultSet.getInt(StringConstant.FLIGHT_AIRCRAFT_MODEL_CAPACITY_KEY.getValue()));
		
		Aircraft aircraft = new Aircraft();
		aircraft.setAircraftID(resultSet.getInt(StringConstant.FLIGHT_AIRCRAFT_ID_KEY.getValue()));
		aircraft.setAircraftSideNumber(resultSet.getString(StringConstant.FLIGHT_AIRCRAFT_SIDE_NUMBER_KEY.getValue()));
		aircraft.setAircraftModel(aircraftModel);
		
		Airport departureAirport = new Airport();
		departureAirport.setAirportID(resultSet.getInt(StringConstant.FLIGHT_DEPARTURE_AIRPORT_ID_KEY.getValue()));
		departureAirport.setAirportCity(resultSet.getString(StringConstant.FLIGHT_DEPARTURE_AIRPORT_CITY_KEY.getValue()));
		
		Airport destinationAirport = new Airport();
		destinationAirport.setAirportID(resultSet.getInt(StringConstant.FLIGHT_DESTINATION_AIRPORT_ID_KEY.getValue()));
		destinationAirport.setAirportCity(resultSet.getString(StringConstant.FLIGHT_DESTINATION_AIRPORT_CITY_KEY.getValue()));		
		
		Flight flight = new Flight();
		
		flight.setFlightID(resultSet.getInt(StringConstant.FLIGHT_ID_KEY.getValue()));
		flight.setDepartureTime(departureTime);
		flight.setLandingTime(landingTime);
		flight.setAircraft(aircraft);
		flight.setDepartureAirport(departureAirport);
		flight.setDestinationAirport(destinationAirport);
		
		return flight;
	}
}
