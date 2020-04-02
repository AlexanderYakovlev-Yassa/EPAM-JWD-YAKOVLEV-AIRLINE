package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.Set;

public interface AircraftDAO {

    Set<AircraftModel> getAllAircraftModels() throws DaoException;
    boolean addAircraft(Aircraft aircraft);
    boolean addAircraftModel(AircraftModel aircraftModel);
}
