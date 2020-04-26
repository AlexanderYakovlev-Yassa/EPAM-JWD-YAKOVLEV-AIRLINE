package by.epam.jwd.yakovlev.airline.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.FlightDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class FlightDAOImpl extends AbstractDAO<Flight> implements FlightDAO {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			StringConstant.DATE_TIME_LONG_FORMAT.getValue());

	@Override
	public Optional<Flight> getFlightByID(int flightID) throws DaoException {
		
		String query = SQLQuery.GET_FLIGHT_BY_ID.getQuery();
		String[] queryParameters = { String.valueOf(flightID) };

		return getEntity(DAOFactoryEnum.FLIGHT, query, queryParameters);
	}

	@Override
	public boolean addFlight(Optional<Flight> flightOptional) throws DaoException {

		String query = SQLQuery.ADD_FLIGHT.getQuery();
		Flight flight = flightOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[5];
		
		String flightDepartureTime = DATE_FORMAT.format(flight.getDepartureTime());
		String flightLandingTime = DATE_FORMAT.format(flight.getLandingTime());
		String flightAircrftID = String.valueOf(flight.getAircraft().getAircraftID());
		String flightDepartureAirportID = String.valueOf(flight.getDepartureAirport().getAirportID());
		String flightDestinationAirportID = String.valueOf(flight.getDestinationAirport().getAirportID());

		queryParameters[0] = flightDepartureTime;
		queryParameters[1] = flightLandingTime;
		queryParameters[2] = flightAircrftID;
		queryParameters[3] = flightDepartureAirportID;
		queryParameters[4] = flightDestinationAirportID;

		return update(query, queryParameters);
	}

	@Override
	public boolean updateFlight(Optional<Flight> flightOptional) throws DaoException {
		
		Flight flight = flightOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));

		String flightDepartureTime = DATE_FORMAT.format(flight.getDepartureTime());
		String flightLandingTime = DATE_FORMAT.format(flight.getLandingTime());
		String flightAircrftID = String.valueOf(flight.getAircraft().getAircraftID());
		String flightDepartureAirportID = String.valueOf(flight.getDepartureAirport().getAirportID());
		String flightDestinationAirportID = String.valueOf(flight.getDestinationAirport().getAirportID());
		String airportID = String.valueOf(flight.getFlightID());

		String[] queryParameters = new String[6];
		String query = SQLQuery.UPDATE_FLIGHT.getQuery();

		queryParameters[0] = flightDepartureTime;
		queryParameters[1] = flightLandingTime;
		queryParameters[2] = flightAircrftID;
		queryParameters[3] = flightDepartureAirportID;
		queryParameters[4] = flightDestinationAirportID;
		queryParameters[5] = airportID;

		return update(query, queryParameters);
	}

	@Override
	public boolean deleteFlight(Optional<Flight> flightOptional) throws DaoException {

		Flight flight = flightOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		
		String flightID = String.valueOf(flight.getFlightID());
		
		String query = SQLQuery.DELETE_FLIGHT.getQuery();
		String[] queryParameters = { flightID };

		return update(query, queryParameters);
	}

	@Override
	public List<Flight> getAllFlightList() throws DaoException {

		String query = SQLQuery.GET_ALL_FLIGHTS.getQuery();
		String[] queryParameters = {};	

		return getEntitiesList(DAOFactoryEnum.FLIGHT, query, queryParameters);
	}
}
