package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCrewRoleFactory extends AbstractDAOFactory<CrewRole> {
	
	@Override
	public CrewRole create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		resultSet.first();

        return createCrewRole(resultSet);
	}
}