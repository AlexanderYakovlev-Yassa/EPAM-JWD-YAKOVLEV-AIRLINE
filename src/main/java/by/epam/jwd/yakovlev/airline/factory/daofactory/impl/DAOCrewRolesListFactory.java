package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOCrewRolesListFactory extends AbstractDAOFactory<List<CrewRole>>{
	
	@Override
	public List<CrewRole> create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		
		List<CrewRole> crewRolesList = new ArrayList<>();
		resultSet.beforeFirst();;
		
		while(resultSet.next()) {
			
			crewRolesList.add(createCrewRole(resultSet));
		}
		
		return crewRolesList;
	}
}
