package by.epam.jwd.yakovlev.airline.service;

import java.util.List;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface AircraftModelService {

	boolean addAircraftModel(AircraftModel aircraftModel) throws ServiceException;
	boolean deleteAircraftModel(AircraftModel aircraftModel) throws ServiceException;
	boolean updateAircraftModel(AircraftModel aircraftModel) throws ServiceException;
	
	Optional<AircraftModel> getAircraftModelByID(int aircraftModelID) throws ServiceException;
	
	List<AircraftModel> getAllAircraftModelsList() throws ServiceException;
}
