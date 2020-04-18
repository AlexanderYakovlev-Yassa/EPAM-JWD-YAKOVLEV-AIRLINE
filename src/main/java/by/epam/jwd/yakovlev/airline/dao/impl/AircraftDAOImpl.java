package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.AircraftDAO;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityType;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class AircraftDAOImpl extends DAO implements AircraftDAO {

	private static final Logger LOGGER = Logger.getLogger(AircraftDAOImpl.class);
	private static final DAOEntityFactory AIRCRAFT_MODEL_FACTORY = DAOEntityType.AIRCRAFT_MODEL.getEntityFactory();
	private static final DAOEntityFactory AIRCRAFT_FACTORY = DAOEntityType.AIRCRAFT.getEntityFactory();

	@Override
	public List<AircraftModel> getAllAircraftModelsList() throws DaoException {
		
		
		  String query = SQLQuery.GET_ALL_AIRCRAFT_MODELS.getQuery(); String[]
		  queryParameters = null;
		  
		  List<Object> objectListOptional =
		  getEntityListFromDB(AIRCRAFT_MODEL_FACTORY, query, queryParameters);
		  
		  List<AircraftModel> aircraftModelsList = new ArrayList<>();
		  
		  for (Object o : objectListOptional) {
			  aircraftModelsList.add((AircraftModel)o);
		  }		 
		
		return aircraftModelsList;
	}

	@Override
	public List<Aircraft> getAllAircraftsList() throws DaoException {
		
		String query = SQLQuery.GET_ALL_AIRCRAFTS.getQuery();
		String[] queryParameters = null;
		
		List<Object> objectListOptional = getEntityListFromDB(AIRCRAFT_FACTORY, query, queryParameters);	
		
		List<Aircraft> aircraftList = new ArrayList<>();
		
		for (Object o : objectListOptional) {
			aircraftList.add((Aircraft)o);
		}
		
		return aircraftList;
	}

	@Override
	public boolean addAircraft(Optional<Aircraft> aircraftOptional) throws DaoException {

		String query = SQLQuery.ADD_AIRCRAFT.getQuery();
		Aircraft aircraft = aircraftOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[2];

		queryParameters[0] = String.valueOf(aircraft.getAircraftModel().getAircraftModelID());
		queryParameters[1] = aircraft.getAircraftSideNumber();

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean addAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException {
		
		String query = SQLQuery.ADD_AIRCRAFT_MODEL.getQuery();
		AircraftModel aircraftModel = aircraftModelOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[2];

		queryParameters[0] = aircraftModel.getAircraftModelName();
		queryParameters[1] = String.valueOf(aircraftModel.getAircraftModelCapacity());

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean deleteAircraftModel(Optional<String> aircraftModelIDOptional) throws DaoException {

		String aircraftModelID = aircraftModelIDOptional.orElse(StringConstant.ZERO.getValue());
		String query = SQLQuery.DELETE_AIRCRAFT_MODEL.getQuery();
		String[] queryParameters = {aircraftModelID};

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean updateAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException {

		if (!aircraftModelOptional.isPresent()) {
			throw new DaoException("There is no aircraft model to update");
		}

		AircraftModel aircraftModel = aircraftModelOptional.get();

		String aircraftModelName = aircraftModel.getAircraftModelName();
		String aircraftModelCapacity = String.valueOf(aircraftModel.getAircraftModelCapacity());
		String aircraftModelID = String.valueOf(aircraftModel.getAircraftModelID());

		String[] queryParameters = new String[3];

		String query = SQLQuery.UPDATE_AIRCRAFT_MODEL_INFO.getQuery();

		queryParameters[0] = aircraftModelName;
		queryParameters[1] = aircraftModelCapacity;
		queryParameters[2] = aircraftModelID;

		return executeQuery(query, queryParameters);
	}

	@Override
	public Optional<Aircraft> getAircraftByID(int aircraftID) throws DaoException {
		
		String query = SQLQuery.GET_AIRCRAFT_BY_ID.getQuery();
		String[] queryParameters = {String.valueOf(aircraftID)};
		
		return getEntityFromDB(AIRCRAFT_FACTORY, query, queryParameters).map(Aircraft.class::cast);
	}

	@Override
	public boolean deleteAircraft(Optional<String> aircraftIDOptional) throws DaoException {

		String aircraftID = aircraftIDOptional.orElse(StringConstant.ZERO.getValue());
		String query = SQLQuery.DELETE_AIRCRAFT.getQuery();
		String[] queryParameters = {aircraftID};

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean updateAircraft(Optional<Aircraft> aircraftOptional) throws DaoException {

		if (!aircraftOptional.isPresent()) {
			throw new DaoException("There is no employee to update");
		}

		Aircraft aircraft = aircraftOptional.get();

		String aircraftModelID = String.valueOf(aircraft.getAircraftModel().getAircraftModelID());
		String aircraftSideNumber = aircraft.getAircraftSideNumber();
		String aircraftID = String.valueOf(aircraft.getAircraftID());

		String[] queryParameters = new String[3];

		String query = SQLQuery.UPDATE_AIRCRAFT_INFO.getQuery();

		queryParameters[0] = aircraftModelID;
		queryParameters[1] = aircraftSideNumber;
		queryParameters[2] = aircraftID;

		return executeQuery(query, queryParameters);
	}

	@Override
	public Optional<AircraftModel> getAircraftModelByID(int id) throws DaoException {

		String query = SQLQuery.GET_AIRCRAFT_MODEL_BY_ID.getQuery();
		String[] queryParameters = { String.valueOf(id) };	

		return getEntityFromDB(DAOEntityType.AIRCRAFT_MODEL.getEntityFactory(), query,	queryParameters).map(AircraftModel.class::cast);
	}
}
