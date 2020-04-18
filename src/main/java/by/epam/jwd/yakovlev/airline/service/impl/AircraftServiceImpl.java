package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.AircraftDAO;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorsEnum;

public class AircraftServiceImpl implements AircraftService {

	private static final Logger LOGGER = Logger.getLogger(AircraftServiceImpl.class);
	private static final AircraftDAO AIRCRAFT_DAO = DAOFactory.INSTANCE.getAircraftDAO();

	@Override
	public boolean addAircraftModel(Optional<Object> objectOptional) throws ServiceException {

		boolean successFlag = false;

		try {
			ValidatorsEnum.AIRCRAFT_MODEL_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e1) {
			LOGGER.debug("The aircraft model is not valid");
			throw new ServiceException("The aircraft model is not valid");
		}

		Optional<AircraftModel> aircraftModelOptional = objectOptional.map(AircraftModel.class::cast);

		try {
			successFlag = AIRCRAFT_DAO.addAircraftModel(aircraftModelOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail add the aircraft model");
			throw new ServiceException("Fail add the aircraft model");
		}

		return successFlag;
	}

	@Override
	public boolean deleteAircraftModel(Optional<String> aircraftModelIDOptional) throws ServiceException {
		
		boolean successFlag = false;

		try {
			successFlag = AIRCRAFT_DAO.deleteAircraftModel(aircraftModelIDOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the aircraf model");
			throw new ServiceException("Fail delete the aircraft model");
		}

		return successFlag;
	}

	@Override
	public boolean updateAircraftModel(Optional<Object> objectOptional) throws ServiceException {

		boolean successFlag = false;

		try {
			ValidatorsEnum.AIRCRAFT_MODEL_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e) {
			LOGGER.debug("Wrong aircraft model parameters");
			throw new ServiceException("Wrong aircraft model parameters", e);
		}

		Optional<AircraftModel> aircraftModelOptional = objectOptional.map(AircraftModel.class::cast);
		
		try {
			successFlag = AIRCRAFT_DAO.updateAircraftModel(aircraftModelOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail update the aircraf model");
			throw new ServiceException("Fail update the aircraft model");
		}

		return successFlag;
	}

	@Override
	public boolean addAircraft(Optional<Object> objectOptional) throws ServiceException {
		
		boolean successFlag = false;

		try {
			ValidatorsEnum.AIRCRAFT_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e1) {
			LOGGER.debug("The aircraft is not valid");
			throw new ServiceException("The aircraft is not valid");
		}

		Optional<Aircraft> aircraftOptional = objectOptional.map(Aircraft.class::cast);

		try {
			successFlag = AIRCRAFT_DAO.addAircraft(aircraftOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail add the aircraft");
			throw new ServiceException("Fail add the aircraft");
		}

		return successFlag;
	}

	@Override
	public boolean deleteAircraft(Optional<String> aircraftIDOptional) throws ServiceException {

		boolean successFlag = false;

		try {
			successFlag = AIRCRAFT_DAO.deleteAircraft(aircraftIDOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the aircraf");
			throw new ServiceException("Fail delete the aircraft");
		}

		return successFlag;
	}

	@Override
	public boolean updateAircraft(Optional<Object> objectOptional) throws ServiceException {

		boolean successFlag = false;
		
		try {
			ValidatorsEnum.AIRCRAFT_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e1) {
			LOGGER.debug("The aircraft is not valid");
			throw new ServiceException("The aircraft is not valid");
		}

		Optional<Aircraft> aircraftOptional = objectOptional.map(Aircraft.class::cast);

		try {
			successFlag = AIRCRAFT_DAO.updateAircraft(aircraftOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail update the aircraf");
			throw new ServiceException("Fail update the aircraft");
		}

		return successFlag;
	}

	@Override
	public Optional<AircraftModel> getAircraftModelByID(int aircraftModelID) throws ServiceException {

		Optional<AircraftModel> aircraftModelOptional = Optional.empty();
		try {
			aircraftModelOptional = AIRCRAFT_DAO.getAircraftModelByID(aircraftModelID);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircraf model");
			throw new ServiceException("Fail get the aircraft model");
		}
		
		return aircraftModelOptional;
	}

	@Override
	public Optional<Aircraft> getAircraftByID(int aircraftID) throws ServiceException {

		Optional<Aircraft> aircraftOptional = Optional.empty();
		try {
			aircraftOptional = AIRCRAFT_DAO.getAircraftByID(aircraftID);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircraf");
			throw new ServiceException("Fail get the aircraft");
		}

		return aircraftOptional;
	}

	@Override
	public List<AircraftModel> getAllAircraftModelsList() throws ServiceException {

		List<AircraftModel> aircraftModelsList = new ArrayList<>();
		try {
			aircraftModelsList = AIRCRAFT_DAO.getAllAircraftModelsList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircraft models list");
			throw new ServiceException("Fail get the aircraft models list");
		}

		return aircraftModelsList;
	}

	@Override
	public List<Aircraft> getAllAircraftsList() throws ServiceException {

		List<Aircraft> aircraftsList = new ArrayList<>();
		try {
			aircraftsList = AIRCRAFT_DAO.getAllAircraftsList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircrafts list");
			throw new ServiceException("Fail get the aircrafts list");
		}

		return aircraftsList;
	}
}
