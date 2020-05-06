package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOSystemRolesListFactory extends AbstractDAOFactory<List<SystemRole>>{
	
	@Override
	public List<SystemRole> create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		
		List<SystemRole> systemRolesList = new ArrayList<>();
		resultSet.beforeFirst();;
		
		while(resultSet.next()) {
			
			systemRolesList.add(createSystemRole(resultSet));
		}
		
		return systemRolesList;
	}
}
