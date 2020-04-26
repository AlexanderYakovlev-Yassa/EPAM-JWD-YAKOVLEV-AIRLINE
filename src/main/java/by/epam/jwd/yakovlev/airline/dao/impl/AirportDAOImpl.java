package by.epam.jwd.yakovlev.airline.dao.impl;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.AirportDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;

public class AirportDAOImpl extends AbstractDAO<Airport> implements AirportDAO {

	@Override
	public boolean addAirport(Optional<Airport> airportOptional) throws DaoException {

		String query = SQLQuery.ADD_AIRPORT.getQuery();
		Airport airport = airportOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[1];

		queryParameters[0] = airport.getAirportCity();

		return update(query, queryParameters);
	}

	@Override
	public boolean updateAirport(Optional<Airport> airportOptional) throws DaoException {
		
		Airport airport = airportOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));

		String airportCity = airport.getAirportCity();
		String airportID = String.valueOf(airport.getAirportID());

		String[] queryParameters = new String[2];

		String query = SQLQuery.UPDATE_AIRPORT.getQuery();

		queryParameters[0] = airportCity;
		queryParameters[1] = airportID;

		return update(query, queryParameters);
	}

	@Override
	public boolean deleteAirport(Optional<Airport> airportOptional) throws DaoException {

		Airport airport = airportOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		
		int airportID = airport.getAirportID();
		String query = SQLQuery.DELETE_AIRPORT.getQuery();
		String[] queryParameters = { String.valueOf(airportID) };

		return update(query, queryParameters);
	}

	@Override
	public Optional<Airport> getAirportByID(int airportID) throws DaoException {
		
		String query = SQLQuery.GET_AIRPORT_BY_ID.getQuery();
		String[] queryParameters = { String.valueOf(airportID) };

		return getEntity(DAOFactoryEnum.AIRPORT, query, queryParameters);
	}

	@Override
	public List<Airport> getAllAirportsList() throws DaoException {

		String query = SQLQuery.GET_ALL_AIRPORTS.getQuery();
		String[] queryParameters = null;

		List<Airport> airportList = getEntitiesList(DAOFactoryEnum.AIRPORT, query, queryParameters);

		return airportList;
	}
}
