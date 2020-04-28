package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.CrewDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

public class CrewDAOImpl extends AbstractDAO<Employee> implements CrewDAO{

	@Override
	public boolean addCrewMember(int flightID, int employeeID) throws DaoException {
		
		String query = SQLQuery.ADD_CREW_MEMBER.getQuery();
		String[] queryParameters = { String.valueOf(flightID), String.valueOf(employeeID) };
		
		return update(query, queryParameters);
	}

	@Override
	public boolean deleteCrewMember(int flightID, int employeeID) throws DaoException {
		
		String query = SQLQuery.DELETE_CREW_MEMBER.getQuery();
		String[] queryParameters = { String.valueOf(flightID), String.valueOf(employeeID) };
		
		return update(query, queryParameters);
	}
}
