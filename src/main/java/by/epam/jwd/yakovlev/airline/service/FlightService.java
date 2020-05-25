package by.epam.jwd.yakovlev.airline.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface FlightService {
	
	/**
     * Adds a flight to a storage
     * @param flight {@see Flight}
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
	boolean addFlight(Flight flight) throws ServiceException;
	
	/**
     * Delete a flight
     * @param flight {@see Flight}
     * @return <tt>true</tt> if deleting was successful
     * @throws ServiceException if deleting fail
     */
	boolean deleteFlight(Flight flight) throws ServiceException;	
	
	/**
     * Update fields value of the flights.
     * Fields available for update:
     * the flight departure time,
     * the flight landing time,
     * the flight departure airport id,
     * the flight destination airport id.
     *  
     * @param flight {@see Flight}
     * @return <tt>true</tt> if updating was successful
     * @throws ServiceException if updating fail
     */
	boolean updateFlight(Flight flight) throws ServiceException;
	
	/**
     * Returns the Optional of flight which was found
     * by flight ID {@see Flight#flightID}
     * 
     * @param flightID - ID of the flight
     * @return Optional of the flight
     */
	Optional<Flight> getFlightByID(int flightID) throws ServiceException;
	
	/**
     * Returns the Optional of flight which which has maximal departure time
     * 
     * @return Optional of the flight
     */
	Optional<Flight> getYoungestFlight() throws ServiceException;
	
	/**
     * Returns the Optional of flight which which has minimal departure time
     * 
     * @return Optional of the flight
     */
	Optional<Flight> getOldestFlight() throws ServiceException;
		
	/**
     * Returns the list of all the flights
     * 
     * @return list of all the flights
     */
	List<Flight> getAllFlightsList() throws ServiceException;
	
	/**
     * Returns the list of all the flights which has departure time
     * between two date
     * 
     * @param firstDate - minimal date of the range
     * @param secondDate - maximal date of the range
     * @return list of flights which are in the selected range
     */
	List<Flight> getFlightsListBetweenDates(Date firstDate, Date secondDate) throws ServiceException;
	
	/**
     * Returns the list of all flights which contain an employee 
     * 
     * @param employeeID - ID of employee
     * @return list of all flights which contain an employee
     */
	List<Flight> getFlightsListByEmployeeID(int employeeID) throws ServiceException;
}
