package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.AircraftDAO;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorFactory;

public class AircraftServiceImpl implements AircraftService {

	private static final Logger LOGGER = Logger.getLogger(AircraftServiceImpl.class);
	private static final AircraftDAO AIRCRAFT_DAO = DAOFactory.getInstance().getAircraftDAO();

	@Override
	public boolean addAircraft(Aircraft aircraft) throws ServiceException {
		
		checkAircraft(aircraft);

		try {
			return AIRCRAFT_DAO.addAircraft(Optional.of(aircraft));
		} catch (DaoException e) {
			LOGGER.debug("Fail add the aircraft", e);
			throw new ServiceException("Fail add the aircraft", e);
		}
	}

	@Override
	public boolean deleteAircraft(Aircraft aircraft) throws ServiceException {

		checkAircraft(aircraft);

		try {
			return AIRCRAFT_DAO.deleteAircraft(Optional.of(aircraft));
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the aircraf", e);
			throw new ServiceException("Fail delete the aircraft", e);
		}
	}

	@Override
	public boolean updateAircraft(Aircraft aircraft) throws ServiceException {

		checkAircraft(aircraft);
		
		try {
			return AIRCRAFT_DAO.updateAircraft(Optional.of(aircraft));
		} catch (DaoException e) {
			LOGGER.debug("Fail update the aircraf", e);
			throw new ServiceException("Fail update the aircraft", e);
		}
	}
	
	@Override
	public Optional<Aircraft> getAircraftByID(int aircraftID) throws ServiceException {

		if (aircraftID < 1) {
			return Optional.empty();
		}
		
		LOGGER.debug("aircraftID - " + aircraftID);
		
		try {
			return AIRCRAFT_DAO.getAircraftByID(aircraftID);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircraf", e);
			throw new ServiceException("Fail get the aircraft", e);
		}
	}
	
	@Override
	public List<Aircraft> getAllAircraftsList() throws ServiceException {

		try {
			return AIRCRAFT_DAO.getAllAircraftsList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the aircrafts list", e);
			throw new ServiceException("Fail get the aircrafts list", e);
		}
	}
	
	private void checkAircraft(Aircraft aircraft) throws ServiceException {
		
		try {
			ValidatorFactory.getInstance().getAircraftValidator().check(aircraft);
		} catch (ValidatorException e) {
			LOGGER.debug("The aircraft is not valid", e);
			throw new ServiceException("The aircraft is not valid", e);
		}
	}
}
