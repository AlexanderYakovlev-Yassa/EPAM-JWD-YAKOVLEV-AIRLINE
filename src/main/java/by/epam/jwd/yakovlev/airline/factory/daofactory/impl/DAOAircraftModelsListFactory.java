package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOAircraftModelsListFactory extends AbstractDAOFactory<List<AircraftModel>>{
	
	@Override
	public List<AircraftModel> create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		
		List<AircraftModel> aircraftModelsList = new ArrayList<>();
		resultSet.beforeFirst();;
		
		while(resultSet.next()) {
			
			aircraftModelsList.add(createAircraftModel(resultSet));
		}
		
		return aircraftModelsList;
	}
}
