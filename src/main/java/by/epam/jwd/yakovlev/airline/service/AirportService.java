package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AirportService {

	boolean addAirpot(Airport airport) throws ServiceException;
	boolean deleteAirport(Airport airport) throws ServiceException;
	boolean updateAirport(Airport airport) throws ServiceException;
	
	Optional<Airport> getAirportByID(int airportID) throws ServiceException;
	
	List<Airport> getAllAirportsList() throws ServiceException;
}
