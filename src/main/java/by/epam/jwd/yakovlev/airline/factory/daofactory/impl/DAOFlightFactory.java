package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOFlightFactory extends AbstractDAOFactory<Flight> {
	
	public Flight create(ResultSet resultSet) throws SQLException, DaoFactoryException {

		checkResultSetForNull(resultSet);
		resultSet.first();
		
		return createFlight(resultSet);
	}
}
