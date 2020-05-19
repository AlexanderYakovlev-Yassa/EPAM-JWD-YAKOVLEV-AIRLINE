package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AircraftService {

	/**
     * Adds an aircraft to a storage
     * @param aircraft {@see Aircraft}
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
	boolean addAircraft(Aircraft aircraft) throws ServiceException;
	
	/**
     * Delete an aircraft
     * @param aircraft {@see Aircraft}
     * @return <tt>true</tt> if deleting was successful
     * @throws ServiceException if deleting fail
     */
	boolean deleteAircraft(Aircraft aircraft) throws ServiceException;
	
	/**
     * Update fields value of the aircraft.
     * Fields available for update:
     * the airport model ID, the aircraft side number.
     * 
     * @param aircraft {@see Aircraft}
     * @return <tt>true</tt> if updating was successful
     * @throws ServiceException if updating fail
     */
	boolean updateAircraft(Aircraft aircraft) throws ServiceException;
	
	/**
     * Returns the Optional of aircraft
     * by aircraft ID {@see Aircraft#aircraftID}
     * 
     * @param aircraftID ID of the aircraft
     * @return Optional of the aircraft
     */
	Optional<Aircraft> getAircraftByID(int aircraftID) throws ServiceException;
	
	
	/**
     * Returns the list of all the aircraft {@see Aircraft}
     * 
     * @return list of all the aircraft
     */
	List<Aircraft> getAllAircraftsList() throws ServiceException;
}
