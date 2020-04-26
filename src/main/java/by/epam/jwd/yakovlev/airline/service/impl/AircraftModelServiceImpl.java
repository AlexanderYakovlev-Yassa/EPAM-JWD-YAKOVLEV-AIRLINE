package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.AircraftModelDAO;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.AircraftModelService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorFactory;

public class AircraftModelServiceImpl implements AircraftModelService {

	private static final Logger LOGGER = Logger.getLogger(AircraftModelServiceImpl.class);
	private static final AircraftModelDAO AIRCRAFT_MODEL_DAO = DAOFactory.getInstance().getAircraftModelDAO();

	@Override
	public boolean addAircraftModel(AircraftModel aircraftModel) throws ServiceException {

		checkAircraftModel(aircraftModel);

		try {
			return AIRCRAFT_MODEL_DAO.addAircraftModel(Optional.of(aircraftModel));
		} catch (DaoException e) {
			LOGGER.debug("Fail add the aircraft model", e);
			throw new ServiceException("Fail add the aircraft model", e);
		}
	}

	@Override
	public boolean deleteAircraftModel(AircraftModel aircraftModel) throws ServiceException {
		
		checkAircraftModel(aircraftModel);

		try {
			return AIRCRAFT_MODEL_DAO.deleteAircraftModel(Optional.of(aircraftModel));
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the aircraf model", e);
			throw new ServiceException("Fail delete the aircraft model", e);
		}
	}

	@Override
	public boolean updateAircraftModel(AircraftModel aircraftModel) throws ServiceException {

		checkAircraftModel(aircraftModel);
		
		try {
			return AIRCRAFT_MODEL_DAO.updateAircraftModel(Optional.of(aircraftModel));
		} catch (DaoException e) {
			LOGGER.debug("Fail update the aircraf model", e);
			throw new ServiceException("Fail update the aircraft model", e);
		}
	}
	
	@Override
	public Optional<AircraftModel> getAircraftModelByID(int aircraftModelID) throws ServiceException {

		if (aircraftModelID < 1) {
			return Optional.empty();
		}
		try {
			return AIRCRAFT_MODEL_DAO.getAircraftModelByID(aircraftModelID);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircraf model", e);
			throw new ServiceException("Fail get the aircraft model", e);
		}
	}

	@Override
	public List<AircraftModel> getAllAircraftModelsList() throws ServiceException {

		try {
			return AIRCRAFT_MODEL_DAO.getAllAircraftModelsList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircraft models list", e);
			throw new ServiceException("Fail get the aircraft models list", e);
		}
	}
	
	private void checkAircraftModel(AircraftModel aircraftModel) throws ServiceException {
		
		try {
			ValidatorFactory.getInstance().getAircraftModelValidator().check(aircraftModel);
		} catch (ValidatorException e) {
			LOGGER.debug("The aircraft model is not valid", e);
			throw new ServiceException("The aircraft model is not valid", e);
		}
	}
}
