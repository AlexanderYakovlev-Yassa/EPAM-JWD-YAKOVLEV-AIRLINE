package by.epam.jwd.yakovlev.airline.dao;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

public interface FlightDAO {

	boolean addFlight(Optional<Flight> flightOptional)  throws DaoException;
	boolean updateFlight(Optional<Flight> flightOptional) throws DaoException;
	boolean deleteFlight(Optional<String> flightID)   throws DaoException;
	
	Optional<Flight> getFlightByID(Optional<String> flightIDOptional) throws DaoException;
	
	List<Flight> getAllFlightList() throws DaoException;
}
