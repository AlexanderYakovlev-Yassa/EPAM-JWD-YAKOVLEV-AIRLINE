package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOAircraftModelFactory extends AbstractDAOFactory<AircraftModel>{
	
	@Override
	public AircraftModel create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		resultSet.first();
		return create(resultSet);
	}
}
