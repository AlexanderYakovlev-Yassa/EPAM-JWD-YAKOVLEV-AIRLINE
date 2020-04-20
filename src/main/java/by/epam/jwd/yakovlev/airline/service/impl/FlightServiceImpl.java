package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.FlightDAO;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.FlightService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorsEnum;

public class FlightServiceImpl implements FlightService{
	
	private static final FlightDAO FLIGHT_DAO = DAOFactory.INSTANCE.getFlightDAO();
	private static final Logger LOGGER = Logger.getLogger(FlightServiceImpl.class);

	@Override
	public boolean addFlight(Optional<Object> objectOptional) throws ServiceException {		
		
		boolean successFlag = false;

		try {
			ValidatorsEnum.FLIGHT_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e1) {
			LOGGER.debug("The flight is not valid");
			throw new ServiceException("The flight is not valid");
		}

		Optional<Flight> flightOptional = objectOptional.map(Flight.class::cast);

		try {
			successFlag = FLIGHT_DAO.addFlight(flightOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail add the flight");
			throw new ServiceException("Fail add the flight");
		}

		return successFlag;
	}

	@Override
	public boolean deleteFlight(Optional<String> flightIDOptional) throws ServiceException {
		
		boolean successFlag = false;

		try {
			successFlag = FLIGHT_DAO.deleteFlight(flightIDOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the flight");
			throw new ServiceException("Fail delete the flight");
		}

		return successFlag;
	}

	@Override
	public boolean updateFlight(Optional<Object> objectOptional) throws ServiceException {
		
		boolean successFlag = false;

		try {
			ValidatorsEnum.FLIGHT_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e) {
			LOGGER.debug("Wrong flight parameters");
			throw new ServiceException("Wrong flight parameters", e);
		}

		Optional<Flight> flightOptional = objectOptional.map(Flight.class::cast);
		
		try {
			successFlag = FLIGHT_DAO.updateFlight(flightOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail update the flight");
			throw new ServiceException("Fail update the flight");
		}

		return successFlag;
	}

	@Override
	public Optional<Flight> getFlightByID(Optional<String> flightIDOptional) throws ServiceException {
		
		Optional<Flight> flightOptional = Optional.empty();
		try {
			flightOptional = FLIGHT_DAO.getFlightByID(flightIDOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the flight");
			throw new ServiceException("Fail get the flight");
		}
		
		return flightOptional;
	}

	@Override
	public List<Flight> getAllFlightsList() throws ServiceException {
		
		List<Flight> flightsList = new ArrayList<>();
		try {
			flightsList = FLIGHT_DAO.getAllFlightList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the flights list");
			throw new ServiceException("Fail get the flights list");
		}

		return flightsList;
	}
}
