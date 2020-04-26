package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.AirportDAO;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorFactory;

public class AirportServiceImpl implements AirportService{
	
	private static final Logger LOGGER = Logger.getLogger(AirportServiceImpl.class);
	private static final AirportDAO AIRPORT_DAO = DAOFactory.getInstance().getAirportDAO();

	@Override
	public boolean addAirpot(Airport airport) throws ServiceException {		

		checkAirport(airport);
		
		try {
			return AIRPORT_DAO.addAirport(Optional.of(airport));
		} catch (DaoException e) {
			LOGGER.debug("Fail add the airport", e);
			throw new ServiceException("Fail add the airport", e);
		}
	}

	@Override
	public boolean deleteAirport(Airport airport) throws ServiceException {
		
		checkAirport(airport);

		try {
			return AIRPORT_DAO.deleteAirport(Optional.of(airport));
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the airport", e);
			throw new ServiceException("Fail delete the airport", e);
		}
	}

	@Override
	public boolean updateAirport(Airport airport) throws ServiceException {

		checkAirport(airport);
				
		try {
			return AIRPORT_DAO.updateAirport(Optional.of(airport));
		} catch (DaoException e) {
			LOGGER.debug("Fail update the airport", e);
			throw new ServiceException("Fail update the airport", e);
		}
	}

	@Override
	public Optional<Airport> getAirportByID(int airportID) throws ServiceException {
		
		if (airportID < 1) {
			return Optional.empty();
		}
		
		try {
			return AIRPORT_DAO.getAirportByID(airportID);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the airport", e);
			throw new ServiceException("Fail get the airport", e);
		}
	}

	@Override
	public List<Airport> getAllAirportsList() throws ServiceException {
		
		try {
			return AIRPORT_DAO.getAllAirportsList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the airports list", e);
			throw new ServiceException("Fail get the airports list", e);
		}
	}
	
	private void checkAirport(Airport airport) throws ServiceException {
		
		try {
			ValidatorFactory.getInstance().getAirportValidator().check(airport);
		} catch (ValidatorException e) {
			LOGGER.debug("Wrong airport parameters", e);
			throw new ServiceException("Wrong airport parameters", e);
		}
	}
}
