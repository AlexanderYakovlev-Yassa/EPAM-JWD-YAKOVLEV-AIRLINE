package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.Crew;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface CrewService {
	
	/**
     * Adds a crew member to the flight
     * @param flightID - flight in which the crew member is adding
     * @param employeeID - the employee ID which should be added
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
	boolean addCrewMember(int flightID, int employeeID) throws ServiceException;
	
	/**
     * Delete a crew member from the flight
     * @param flightID - flight in which the crew member is deleting
     * @param employeeID - the employee ID which should be deleted
     * @return <tt>true</tt> if deleting was successful
     * @throws ServiceException if deleting fail
     */
	boolean deleteCrewMember(int flightID, int employeeID) throws ServiceException;
	
	/**
     * Return the crew by flight ID which this crew is belong
     * 
     * @param flightID - ID of the flight
     * @return the flight crew 
     */
	Crew getCrewByFlightID(int flightID) throws ServiceException;
}
