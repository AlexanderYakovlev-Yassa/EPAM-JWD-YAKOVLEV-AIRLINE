package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.Date;
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
import by.epam.jwd.yakovlev.airline.validator.ValidatorFactory;
import by.epam.jwd.yakovlev.airline.validator.impl.DateTimeValidator;

public class FlightServiceImpl implements FlightService {

	private static final FlightDAO FLIGHT_DAO = DAOFactory.getInstance().getFlightDAO();

	private static final Logger LOGGER = Logger.getLogger(FlightServiceImpl.class);

	@Override
	public boolean addFlight(Flight flight) throws ServiceException {

		checkFlight(flight);

		try {
			return FLIGHT_DAO.addFlight(Optional.of(flight));
		} catch (DaoException e) {
			LOGGER.debug("Fail add the flight", e);
			throw new ServiceException("Fail add the flight", e);
		}
	}

	@Override
	public boolean deleteFlight(Flight flight) throws ServiceException {

		checkFlight(flight);

		try {
			return FLIGHT_DAO.deleteFlight(Optional.of(flight));
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the flight", e);
			throw new ServiceException("Fail delete the flight", e);
		}
	}

	@Override
	public boolean updateFlight(Flight flight) throws ServiceException {

		checkFlight(flight);

		try {
			return FLIGHT_DAO.updateFlight(Optional.of(flight));
		} catch (DaoException e) {
			LOGGER.debug("Fail update the flight", e);
			throw new ServiceException("Fail update the flight", e);
		}
	}

	@Override
	public Optional<Flight> getFlightByID(int flightID) throws ServiceException {

		if (flightID < 1) {
			return Optional.empty();
		}

		try {
			return FLIGHT_DAO.getFlightByID(flightID);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the flight", e);
			throw new ServiceException("Fail get the flight", e);
		}
	}

	@Override
	public List<Flight> getAllFlightsList() throws ServiceException {

		try {
			return FLIGHT_DAO.getAllFlightList();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the flights list", e);
			throw new ServiceException("Fail get the flights list", e);
		}
	}

	@Override
	public List<Flight> getFlightsListBetweenDates(Date firstDate, Date secondDate) throws ServiceException {

		DateTimeValidator validator = ValidatorFactory.getInstance().getDateTimeValidator();

		try {
			validator.isDateValid(firstDate);
			validator.isDateValid(secondDate);
			validator.checkOrderOfDates(firstDate, secondDate);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
		try {
			return FLIGHT_DAO.getFlightsListBetweenDates(firstDate, secondDate);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the flights list", e);
			throw new ServiceException("Fail get the flights list", e);
		}
	}

	private void checkFlight(Flight flight) throws ServiceException {

		try {
			ValidatorFactory.getInstance().getFlightValidator().check(flight);
		} catch (ValidatorException e) {
			LOGGER.debug("The flight ID is not valid", e);
			throw new ServiceException("The flight ID is not valid", e);
		}
	}

	@Override
	public Optional<Flight> getYoungestFlight() throws ServiceException {
		
		try {
			return FLIGHT_DAO.getYoungestFlight();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the youngest flight", e);
			throw new ServiceException("Fail get the youngest flight", e);
		}
	}

	@Override
	public Optional<Flight> getOldestFlight() throws ServiceException {
		
		try {
			return FLIGHT_DAO.getOldestFlight();
		} catch (DaoException e) {
			LOGGER.debug("Fail get the oldest flight", e);
			throw new ServiceException("Fail get the oldest flight", e);
		}
	}

	@Override
	public List<Flight> getFlightsListByEmployeeID(int employeeID) throws ServiceException {
		
		try {
			return FLIGHT_DAO.getFlightsListByEmployeeID(employeeID);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the oldest flight", e);
			throw new ServiceException("Fail get the oldest flight", e);
		}
	}
}
