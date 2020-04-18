package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AircraftDAO {

	boolean addAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException;
	boolean deleteAircraftModel(Optional<String> aircraftModelIDOptional) throws DaoException;
	boolean updateAircraftModel(Optional<AircraftModel> aircraftModelOptional) throws DaoException;
	boolean addAircraft(Optional<Aircraft> aircraftOptional) throws DaoException;
	boolean deleteAircraft(Optional<String> aircraftIDOptional) throws DaoException;
	boolean updateAircraft(Optional<Aircraft> aircraftOptional) throws DaoException;
    
	Optional<AircraftModel> getAircraftModelByID(int aircraftModelID)  throws DaoException;
	Optional<Aircraft> getAircraftByID(int aircraftModelID)  throws DaoException;
    
    List<AircraftModel> getAllAircraftModelsList() throws DaoException;
    List<Aircraft> getAllAircraftsList() throws DaoException;
}
