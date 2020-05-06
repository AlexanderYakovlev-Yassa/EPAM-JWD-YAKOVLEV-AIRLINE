package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOAircraftsListFactory extends AbstractDAOFactory<List<Aircraft>>{
	
	@Override
	public List<Aircraft> create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		
		List<Aircraft> aircraftsList = new ArrayList<>();
		resultSet.beforeFirst();;
		
		while(resultSet.next()) {
			
			aircraftsList.add(createAircraft(resultSet));
		}
		
		return aircraftsList;
	}
}
