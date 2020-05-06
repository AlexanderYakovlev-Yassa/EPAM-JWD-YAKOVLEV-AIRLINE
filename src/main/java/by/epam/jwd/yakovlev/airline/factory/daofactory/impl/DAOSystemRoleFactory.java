package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOSystemRoleFactory extends AbstractDAOFactory<SystemRole> {
    
	@Override
	public SystemRole create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		resultSet.first();

        return createSystemRole(resultSet);
	}
}
