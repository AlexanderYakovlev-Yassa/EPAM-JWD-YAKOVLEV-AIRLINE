package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.dao.SystemRoleDAO;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import java.util.*;

public class SystemRoleDAOImpl extends AbstractDAO<SystemRole> implements SystemRoleDAO {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemRole> getAllSystemRolesList() throws DaoException {

		String query = SQLQuery.GET_ALL_SYSTEM_ROLES.getQuery();
		String[] queryParameters = null;	
		
		return (List<SystemRole>) getEntity(DAOFactoryEnum.SYSTEM_ROLES_LIST, query, queryParameters);
	}
	
	@Override
	public Optional<SystemRole> getSystemRoleByID(int ID) throws DaoException {

		String query = SQLQuery.GET_SYSTEM_ROLE_BY_ID.getQuery();
		String[] queryParameter = { String.valueOf(ID) };
		
		SystemRole systemRole = getEntity(DAOFactoryEnum.SYSTEM_ROLE, query, queryParameter);
		
		return systemRole != null ? Optional.of(systemRole) : Optional.empty();
	}

	@Override
	public boolean addSystemRole(Optional<SystemRole> systemRoleOptional) throws DaoException {

		String query = SQLQuery.ADD_SYSTEM_ROLE.getQuery();
		SystemRole systemRole = systemRoleOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		String[] queryParameters = new String[1];

		queryParameters[0] = systemRole.getSystemRoleName();

		return update(query, queryParameters);
	}

	@Override
	public boolean updateSystemRole(Optional<SystemRole> systemRoleOptional) throws DaoException {

		if (!systemRoleOptional.isPresent()) {
			throw new DaoException("There is no systemRole to update");
		}

		SystemRole systemRole = systemRoleOptional.get();

		String systemRoleName = systemRole.getSystemRoleName();
		String systemRoleID = String.valueOf(systemRole.getSystemRoleID());

		String[] queryParameters = new String[2];

		String query = SQLQuery.UPDATE_SYSTEM_ROLE.getQuery();

		queryParameters[0] = systemRoleName;
		queryParameters[1] = systemRoleID;

		return update(query, queryParameters);
	}

	@Override
	public boolean deleteSystemRole(Optional<SystemRole> systemRoleOptional) throws DaoException {
		
		SystemRole systemRole = systemRoleOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		
		int systemRoleID = systemRole.getSystemRoleID();
		String query = SQLQuery.DELETE_SYSTEM_ROLE.getQuery();
		String[] queryParameters = { String.valueOf(systemRoleID) };

		return update(query, queryParameters);
	}
}