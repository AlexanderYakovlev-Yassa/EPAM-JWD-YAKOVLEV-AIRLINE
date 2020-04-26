package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.AircraftModelDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import java.util.List;
import java.util.Optional;
public class AircraftModelDAOImpl extends AbstractDAO<AircraftModel> implements AircraftModelDAO {

	@Override
	public List<AircraftModel> getAllAircraftModelsList() throws DaoException {		
		
		  String query = SQLQuery.GET_ALL_AIRCRAFT_MODELS.getQuery(); String[]
		  queryParameters = null;
		  
		  List<AircraftModel> aircraftModelsList = getEntitiesList(DAOFactoryEnum.AIRCRAFT_MODEL, query, queryParameters);
		  
		return aircraftModelsList;
	}

	@Override
	public boolean addAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException {
		
		String query = SQLQuery.ADD_AIRCRAFT_MODEL.getQuery();
		AircraftModel aircraftModel = aircraftModelOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[2];

		queryParameters[0] = aircraftModel.getAircraftModelName();
		queryParameters[1] = String.valueOf(aircraftModel.getAircraftModelCapacity());

		return update(query, queryParameters);
	}

	@Override
	public boolean deleteAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException {

		AircraftModel aircraftModel = aircraftModelOptional
				.orElseThrow(() -> new DaoException("Fail delete due to null argument"));
		
		String aircraftModelID = String.valueOf(aircraftModel.getAircraftModelID());
		
		String query = SQLQuery.DELETE_AIRCRAFT_MODEL.getQuery();
		String[] queryParameters = { aircraftModelID };
		
		return update(query, queryParameters);
	}

	@Override
	public boolean updateAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException {

		AircraftModel aircraftModel = aircraftModelOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		
		String aircraftModelName = aircraftModel.getAircraftModelName();
		String aircraftModelCapacity = String.valueOf(aircraftModel.getAircraftModelCapacity());
		String aircraftModelID = String.valueOf(aircraftModel.getAircraftModelID());

		String[] queryParameters = new String[3];

		String query = SQLQuery.UPDATE_AIRCRAFT_MODEL.getQuery();

		queryParameters[0] = aircraftModelName;
		queryParameters[1] = aircraftModelCapacity;
		queryParameters[2] = aircraftModelID;

		return update(query, queryParameters);
	}

	@Override
	public Optional<AircraftModel> getAircraftModelByID(int id) throws DaoException {

		String query = SQLQuery.GET_AIRCRAFT_MODEL_BY_ID.getQuery();
		String[] queryParameters = { String.valueOf(id) };	

		return getEntity(DAOFactoryEnum.AIRCRAFT_MODEL, query,	queryParameters);
	}
}
