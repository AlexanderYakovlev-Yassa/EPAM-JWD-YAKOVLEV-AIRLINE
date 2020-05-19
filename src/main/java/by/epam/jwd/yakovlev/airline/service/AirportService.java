package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AirportService {

	/**
     * Adds an airport to a storage
     * @param airport {@see Airport}
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
	boolean addAirpot(Airport airport) throws ServiceException;
	
	/**
     * Delete an airport
     * @param airport {@see Airport}
     * @return <tt>true</tt> if deleting was successful
     * @throws ServiceException if deleting fail
     */
	boolean deleteAirport(Airport airport) throws ServiceException;	

	/**
     * Update fields value of the aircraft.
     * Fields available for update:
     * the airport city.
     * 
     * @param airport {@see Airport}
     * @return <tt>true</tt> if updating was successful
     * @throws ServiceException if updating fail
     */
	boolean updateAirport(Airport airport) throws ServiceException;
	
	/**
     * Returns the Optional of airport
     * by airport ID {@see Airport#airportID}
     * 
     * @param airportID ID of the airport
     * @return Optional of the airport
     */
	Optional<Airport> getAirportByID(int airportID) throws ServiceException;
	
	/**
     * Returns the list of all the airport
     * 
     * @return list of all the airport
     */
	List<Airport> getAllAirportsList() throws ServiceException;
}
