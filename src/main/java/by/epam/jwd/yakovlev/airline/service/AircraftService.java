package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AircraftService {

	boolean addAircraftModel(Optional<Object> aircraftModelOptional) throws ServiceException;
	boolean deleteAircraftModel(Optional<String> aircraftModelIDOptional) throws ServiceException;
	boolean updateAircraftModel(Optional<Object> aircraftModelOptional) throws ServiceException;
	boolean addAircraft(Optional<Object> aircraftOptional) throws ServiceException;
	boolean deleteAircraft(Optional<String> aircraftIDOptional) throws ServiceException;
	boolean updateAircraft(Optional<Object> aircraftOptional) throws ServiceException;
	
	Optional<AircraftModel> getAircraftModelByID(int aircraftModelID) throws ServiceException;
	Optional<Aircraft> getAircraftByID(int aircraftID) throws ServiceException;
	
	List<AircraftModel> getAllAircraftModelsList() throws ServiceException;
	List<Aircraft> getAllAircraftsList() throws ServiceException;
}
