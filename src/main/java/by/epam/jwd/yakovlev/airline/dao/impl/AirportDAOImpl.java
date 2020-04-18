package by.epam.jwd.yakovlev.airline.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.AirportDAO;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityType;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class AirportDAOImpl extends DAO implements AirportDAO{
	
	private static final Logger LOGGER = Logger.getLogger(AirportDAOImpl.class);
	private static final DAOEntityFactory AIRPORT_FACTORY = DAOEntityType.AIRPORT.getEntityFactory();

	@Override
	public boolean addAirport(Optional<Airport> airportOptional) throws DaoException {
		
		String query = SQLQuery.ADD_AIRPORT.getQuery();
		Airport airport = airportOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[1];

		queryParameters[0] = airport.getAirportCity();		

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean updateAirport(Optional<Airport> airportOptional) throws DaoException {
		
		if (!airportOptional.isPresent()) {
			throw new DaoException("There is no airport to update");
		}

		Airport airport = airportOptional.get();

		String airportCity = airport.getAirportCity();
		String airportID = String.valueOf(airport.getAirportID());

		String[] queryParameters = new String[2];

		String query = SQLQuery.UPDATE_AIRPORT.getQuery();

		queryParameters[0] = airportCity;
		queryParameters[1] = airportID;

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean deleteAirport(Optional<String> airportIDOptional) throws DaoException {
		
		String airportID = airportIDOptional.orElse(StringConstant.ZERO.getValue());
		String query = SQLQuery.DELETE_AIRPORT.getQuery();
		String[] queryParameters = {airportID};

		return executeQuery(query, queryParameters);
	}

	@Override
	public Optional<Airport> getAirportByID(Optional<String> airportIDOptional) throws DaoException {
		
		String airportID = airportIDOptional.orElse(StringConstant.ZERO.getValue());
		String query = SQLQuery.GET_AIRPORT_BY_ID.getQuery();
		String[] queryParameters = { String.valueOf(airportID) };	

		return getEntityFromDB(DAOEntityType.AIRPORT.getEntityFactory(), query,	queryParameters).map(Airport.class::cast);
	}

	@Override
	public List<Airport> getAllAirportsList() throws DaoException {

		String query = SQLQuery.GET_ALL_AIRPORTS.getQuery(); String[]
				  queryParameters = null;
				  
				  List<Object> objectListOptional =
				  getEntityListFromDB(AIRPORT_FACTORY, query, queryParameters);
				  
				  List<Airport> airportList = new ArrayList<>();
				  
				  for (Object o : objectListOptional) {
					  airportList.add((Airport)o);
				  }		 
				
				return airportList;
	}
}
