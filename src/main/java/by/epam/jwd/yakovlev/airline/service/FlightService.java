package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface FlightService {

	boolean addFlight(Optional<Object> flightOptional) throws ServiceException;
	boolean deleteFlight(Optional<String> flightIDOptional) throws ServiceException;
	boolean updateFlight(Optional<Object> flightOptional) throws ServiceException;
	
	Optional<Flight> getFlightByID(Optional<String> flightIDOptional) throws ServiceException;
	
	List<Flight> getAllFlightsList() throws ServiceException;
}
