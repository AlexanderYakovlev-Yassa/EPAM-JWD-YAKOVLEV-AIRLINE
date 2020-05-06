package by.epam.jwd.yakovlev.airline.dao.impl;

import java.util.Optional;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.CrewDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.Crew;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;

public class CrewDAOImpl extends AbstractDAO<Crew> implements CrewDAO{

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

	@Override
	public Optional<Crew> getCrewByFlightID(int flightID) throws DaoException {
		
		String query = SQLQuery.GET_CREW_BY_FLIGHT_ID.getQuery();
		String[] queryParameters = { String.valueOf(flightID) };
		
		Crew crew = getEntity(DAOFactoryEnum.CREW, query, queryParameters);
		
		return crew != null ? Optional.of(crew) : Optional.empty();
	}
}
