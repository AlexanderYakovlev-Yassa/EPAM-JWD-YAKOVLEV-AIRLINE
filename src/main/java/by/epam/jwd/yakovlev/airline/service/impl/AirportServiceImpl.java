package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.AircraftDAO;
import by.epam.jwd.yakovlev.airline.dao.AirportDAO;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorsEnum;

public class AirportServiceImpl implements AirportService{
	
	private static final Logger LOGGER = Logger.getLogger(AirportServiceImpl.class);
	private static final AirportDAO AIRPORT_DAO = DAOFactory.INSTANCE.getAirportDAO();

	@Override
	public boolean addAirpot(Optional<Object> objectOptional) throws ServiceException {
		
		boolean successFlag = false;

		try {
			ValidatorsEnum.AIRPORT_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e1) {
			LOGGER.debug("The airport is not valid");
			throw new ServiceException("The airport is not valid");
		}

		Optional<Airport> airportOptional = objectOptional.map(Airport.class::cast);

		try {
			successFlag = AIRPORT_DAO.addAirport(airportOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail add the airport");
			throw new ServiceException("Fail add the airport");
		}

		return successFlag;
	}

	@Override
	public boolean deleteAirport(Optional<String> airportIDOptional) throws ServiceException {
		
		boolean successFlag = false;

		try {
			successFlag = AIRPORT_DAO.deleteAirport(airportIDOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the airport");
			throw new ServiceException("Fail delete the airport");
		}

		return successFlag;
	}

	@Override
	public boolean updateAirport(Optional<Object> objectOptional) throws ServiceException {
		
		boolean successFlag = false;

		try {
			ValidatorsEnum.AIRPORT_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e) {
			LOGGER.debug("Wrong airport parameters");
			throw new ServiceException("Wrong airport parameters", e);
		}

		Optional<Airport> airportOptional = objectOptional.map(Airport.class::cast);
		
		try {
			successFlag = AIRPORT_DAO.updateAirport(airportOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail update the airport");
			throw new ServiceException("Fail update the airport");
		}

		return successFlag;
	}

	@Override
	public Optional<Airport> getAirportlByID(Optional<String> airportIDOptional) throws ServiceException {
		
		Optional<Airport> airportOptional = Optional.empty();
		try {
			airportOptional = AIRPORT_DAO.getAirportByID(airportIDOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the airport");
			throw new ServiceException("Fail get the airport");
		}
		
		return airportOptional;
	}

	@Override
	public List<Airport> getAllAirportList() throws ServiceException {
		
		List<Airport> airportList = new ArrayList<>();
		try {
			airportList = AIRPORT_DAO.getAllAirportsList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the airports list");
			throw new ServiceException("Fail get the airports list");
		}

		return airportList;
	}
	
	

}
