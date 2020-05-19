package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AircraftModelService {

	/**
     * Adds an aircraft model to a storage
     * @param aircraftModel {@see AircraftModel}
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
	boolean addAircraftModel(AircraftModel aircraftModel) throws ServiceException;
	
	/**
     * Delete an aircraft model
     * @param aircraftModel {@see AircraftModel}
     * @return <tt>true</tt> if deleting was successful
     * @return <tt>false</tt> if aircraft model was not deleted
     * @throws ServiceException if deleting fail
     */
	boolean deleteAircraftModel(AircraftModel aircraftModel) throws ServiceException;
	
	/**
     * Update the name {@see AircraftModel#aircraftModelName} 
     * and capacity {@see AircraftModel#aircraftModelCapacity} 
     * of an aircraft model in a storage
     * 
     * @param aircraftModel {@see AircraftModel}
     * @return <tt>true</tt> if updating was successful
     * @return <tt>false</tt> if aircraft model was not updated
     * @throws ServiceException if updating fail
     */
	boolean updateAircraftModel(AircraftModel aircraftModel) throws ServiceException;
	
	/**
     * Returns the aircraft model {@see AircraftModel} 
     * by aircraft model ID {@see AircraftModel#aircraftModelID}
     * 
     * @param aircraftModelID ID of the aircraft model
     * @return aircraft model
     */
	Optional<AircraftModel> getAircraftModelByID(int aircraftModelID) throws ServiceException;
	
	/**
     * Returns the list of all the aircraft model {@see AircraftModel}
     * 
     * @return list of all the aircraft models
     */
	List<AircraftModel> getAllAircraftModelsList() throws ServiceException;
}
