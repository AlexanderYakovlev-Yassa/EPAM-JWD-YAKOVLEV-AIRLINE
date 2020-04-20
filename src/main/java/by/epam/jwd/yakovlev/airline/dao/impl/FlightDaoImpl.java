package by.epam.jwd.yakovlev.airline.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.dao.FlightDAO;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityType;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class FlightDaoImpl extends DAO implements FlightDAO {

	private static final DAOEntityFactory FLIGHT_FACTORY = DAOEntityType.FLIGHT.getEntityFactory();
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			StringConstant.DATE_TIME_FORMAT.getValue());

	@Override
	public Optional<Flight> getFlightByID(Optional<String> flightIDOptional) throws DaoException {

		String flightID = flightIDOptional.orElse(StringConstant.ZERO.getValue());
		String query = SQLQuery.GET_FLIGHT_BY_ID.getQuery();
		String[] queryParameters = { flightID };

		return getEntityFromDB(FLIGHT_FACTORY, query, queryParameters).map(Flight.class::cast);
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

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean updateFlight(Optional<Flight> flightOptional) throws DaoException {

		if (!flightOptional.isPresent()) {
			throw new DaoException("There is no flight to update");
		}

		Flight flight = flightOptional.get();

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

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean deleteFlight(Optional<String> flightIDOptional) throws DaoException {

		String flightID = flightIDOptional.orElse(StringConstant.ZERO.getValue());
		String query = SQLQuery.DELETE_FLIGHT.getQuery();
		String[] queryParameters = { flightID };

		return executeQuery(query, queryParameters);
	}

	@Override
	public List<Flight> getAllFlightList() throws DaoException {

		String query = SQLQuery.GET_ALL_FLIGHTS.getQuery();
		String[] queryParameters = null;

		List<Object> objectListOptional = getEntityListFromDB(FLIGHT_FACTORY, query, queryParameters);

		List<Flight> flightsList = new ArrayList<>();

		for (Object o : objectListOptional) {
			flightsList.add((Flight) o);
		}

		return flightsList;
	}
}
