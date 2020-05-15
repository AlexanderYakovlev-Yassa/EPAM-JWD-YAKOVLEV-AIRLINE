package by.epam.jwd.yakovlev.airline.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

public interface FlightDAO {

	boolean addFlight(Optional<Flight> flightOptional)  throws DaoException;
	boolean updateFlight(Optional<Flight> flightOptional) throws DaoException;
	boolean deleteFlight(Optional<Flight> flightID)   throws DaoException;
	
	Optional<Flight> getFlightByID(int flightID) throws DaoException;
	Optional<Flight> getYoungestFlight() throws DaoException;
	Optional<Flight> getOldestFlight() throws DaoException;
	
	List<Flight> getAllFlightList() throws DaoException;
	List<Flight> getFlightsListBetweenDates(Date firstDate, Date secondDate) throws DaoException;
}
