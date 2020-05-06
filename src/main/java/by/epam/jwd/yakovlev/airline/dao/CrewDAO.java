package by.epam.jwd.yakovlev.airline.dao;

import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Crew;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

public interface CrewDAO {

	boolean addCrewMember(int flightID, int employeeID) throws DaoException;
	boolean deleteCrewMember(int flightID, int employeeID) throws DaoException;
	Optional<Crew> getCrewByFlightID(int flightID) throws DaoException;
}