package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AircraftModelDAO {

	boolean addAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException;
	boolean deleteAircraftModel(Optional<AircraftModel> aircraftModelIDOptional) throws DaoException;
	boolean updateAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException;	
    
	Optional<AircraftModel> getAircraftModelByID(int aircraftModelID)  throws DaoException;
	
    List<AircraftModel> getAllAircraftModelsList() throws DaoException;
}
