package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AircraftService {

	boolean addAircraft(Aircraft aircraft) throws ServiceException;
	boolean deleteAircraft(Aircraft aircraft) throws ServiceException;
	boolean updateAircraft(Aircraft aircraft) throws ServiceException;
	
	Optional<Aircraft> getAircraftByID(int aircraftID) throws ServiceException;
	
	List<Aircraft> getAllAircraftsList() throws ServiceException;
}
