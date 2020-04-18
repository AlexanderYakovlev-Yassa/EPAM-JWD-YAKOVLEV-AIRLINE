package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AirportService {

	boolean addAirpot(Optional<Object> airportOptional) throws ServiceException;
	boolean deleteAirport(Optional<String> airportIDOptional) throws ServiceException;
	boolean updateAirport(Optional<Object> airportOptional) throws ServiceException;
	
	Optional<Airport> getAirportlByID(Optional<String> airportIDOptional) throws ServiceException;
	
	List<Airport> getAllAirportList() throws ServiceException;
}
