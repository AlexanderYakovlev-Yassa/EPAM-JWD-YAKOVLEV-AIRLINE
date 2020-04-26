package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AircraftDAO {

	boolean addAircraft(Optional<Aircraft> aircraftOptional) throws DaoException;
	boolean deleteAircraft(Optional<Aircraft> aircraftIDOptional) throws DaoException;
	boolean updateAircraft(Optional<Aircraft> aircraftOptional) throws DaoException;
    
	Optional<Aircraft> getAircraftByID(int aircraftID)  throws DaoException;
    
    List<Aircraft> getAllAircraftsList() throws DaoException;
}
