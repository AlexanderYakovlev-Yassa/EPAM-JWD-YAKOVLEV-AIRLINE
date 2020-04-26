package by.epam.jwd.yakovlev.airline.dao;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

public interface AirportDAO {

	boolean addAirport(Optional<Airport> airportOptional) throws DaoException;
	boolean updateAirport(Optional<Airport> airportOptional) throws DaoException;
	boolean deleteAirport(Optional<Airport> airportOptional) throws DaoException;
	
	Optional<Airport> getAirportByID(int airportID) throws DaoException;
	
	List<Airport> getAllAirportsList() throws DaoException;
}
