package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOAirportFactory extends AbstractDAOFactory<Airport>{
	
	@Override
	public Airport create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		resultSet.first();
		return createAirport(resultSet);
	}
}
