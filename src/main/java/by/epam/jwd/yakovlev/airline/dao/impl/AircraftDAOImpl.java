package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.AircraftDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import java.util.List;
import java.util.Optional;
public class AircraftDAOImpl extends AbstractDAO<Aircraft> implements AircraftDAO {
	
	@Override
	public List<Aircraft> getAllAircraftsList() throws DaoException {
		
		String query = SQLQuery.GET_ALL_AIRCRAFTS.getQuery();
		String[] queryParameters = null;
		
		@SuppressWarnings("unchecked")
		List<Aircraft> aircraftList = (List<Aircraft>) getEntity(DAOFactoryEnum.AIRCRAFTS_LIST, query, queryParameters);	
		
		return aircraftList;
	}

	@Override
	public boolean addAircraft(Optional<Aircraft> aircraftOptional) throws DaoException {

		String query = SQLQuery.ADD_AIRCRAFT.getQuery();
		Aircraft aircraft = aircraftOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[2];

		queryParameters[0] = String.valueOf(aircraft.getAircraftModel().getAircraftModelID());
		queryParameters[1] = aircraft.getAircraftSideNumber();

		return update(query, queryParameters);
	}

	@Override
	public Optional<Aircraft> getAircraftByID(int aircraftID) throws DaoException {
		
		String query = SQLQuery.GET_AIRCRAFT_BY_ID.getQuery();
		String[] queryParameters = {String.valueOf(aircraftID)};
		
		Aircraft aircraft = getEntity(DAOFactoryEnum.AIRCRAFT, query, queryParameters);
		
		return aircraft != null ? Optional.of(aircraft) : Optional.empty();
	}

	@Override
	public boolean deleteAircraft(Optional<Aircraft> aircraftOptional) throws DaoException {

		Aircraft aircraft = aircraftOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		int aircraftID = aircraft.getAircraftID();
		String query = SQLQuery.DELETE_AIRCRAFT.getQuery();
		String[] queryParameters = {String.valueOf(aircraftID)};

		return update(query, queryParameters);
	}

	@Override
	public boolean updateAircraft(Optional<Aircraft> aircraftOptional) throws DaoException {

		Aircraft aircraft = aircraftOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));

		String aircraftModelID = String.valueOf(aircraft.getAircraftModel().getAircraftModelID());
		String aircraftSideNumber = aircraft.getAircraftSideNumber();
		String aircraftID = String.valueOf(aircraft.getAircraftID());

		String[] queryParameters = new String[3];

		String query = SQLQuery.UPDATE_AIRCRAFT.getQuery();

		queryParameters[0] = aircraftModelID;
		queryParameters[1] = aircraftSideNumber;
		queryParameters[2] = aircraftID;

		return update(query, queryParameters);
	}
}
