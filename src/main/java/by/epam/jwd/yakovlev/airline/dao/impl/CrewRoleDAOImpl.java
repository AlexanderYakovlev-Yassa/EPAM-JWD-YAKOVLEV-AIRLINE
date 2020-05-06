package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.CrewRoleDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import java.util.*;

public class CrewRoleDAOImpl extends AbstractDAO<CrewRole> implements CrewRoleDAO {
	
	@Override
	public List<CrewRole> getAllCrewRolesList() throws DaoException {

		String query = SQLQuery.GET_ALL_CREW_ROLE.getQuery();
		String[] queryParameters = null;
		
		@SuppressWarnings("unchecked")
		List<CrewRole> crewRolesList = (List<CrewRole>) getEntity(DAOFactoryEnum.CREW_ROLES_LIST, query, queryParameters);	
		
		return crewRolesList;
	}
	
	@Override
	public Optional<CrewRole> getCrewRoleByID(int ID) throws DaoException {

		String query = SQLQuery.GET_CREW_ROLE_BY_ID.getQuery();
		String[] queryParameter = { String.valueOf(ID) };
		
		CrewRole crewRole = getEntity(DAOFactoryEnum.CREW_ROLE, query, queryParameter);
		
		return crewRole != null ? Optional.of(crewRole) : Optional.empty();
	}

	@Override
	public boolean addCrewRole(Optional<CrewRole> crewRoleOptional) throws DaoException {

		String query = SQLQuery.ADD_CREW_ROLE.getQuery();
		CrewRole crewRole = crewRoleOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[1];

		queryParameters[0] = crewRole.getCrewRoleName();

		return update(query, queryParameters);
	}

	@Override
	public boolean updateCrewRole(Optional<CrewRole> crewRoleOptional) throws DaoException {

		if (!crewRoleOptional.isPresent()) {
			throw new DaoException("There is no crewRole to update");
		}

		CrewRole crewRole = crewRoleOptional.get();

		String crewRoleName = crewRole.getCrewRoleName();
		String crewRoleID = String.valueOf(crewRole.getCrewRoleID());

		String[] queryParameters = new String[2];

		String query = SQLQuery.UPDATE_CREW_ROLE.getQuery();

		queryParameters[0] = crewRoleName;
		queryParameters[1] = crewRoleID;

		return update(query, queryParameters);
	}

	@Override
	public boolean deleteCrewRole(Optional<CrewRole> crewRoleOptional) throws DaoException {
		
		CrewRole crewRole = crewRoleOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		
		int crewRoleID = crewRole.getCrewRoleID();
		String query = SQLQuery.DELETE_CREW_ROLE.getQuery();
		String[] queryParameters = { String.valueOf(crewRoleID) };

		return update(query, queryParameters);
	}
}