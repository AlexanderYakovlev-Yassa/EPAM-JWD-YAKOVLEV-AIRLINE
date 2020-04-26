package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface FlightService {

	boolean addFlight(Flight flight) throws ServiceException;
	boolean deleteFlight(Flight flight) throws ServiceException;
	boolean updateFlight(Flight flight) throws ServiceException;
	
	Optional<Flight> getFlightByID(int flightID) throws ServiceException;
	
	List<Flight> getAllFlightsList() throws ServiceException;
}
