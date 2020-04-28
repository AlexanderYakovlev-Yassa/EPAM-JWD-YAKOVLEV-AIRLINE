package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.exception.DaoException;

public interface CrewDAO {

	boolean addCrewMember(int flightID, int employeeID) throws DaoException;
	boolean deleteCrewMember(int flightID, int employeeID) throws DaoException;
}