package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOFlightsListFactory extends AbstractDAOFactory<List<Flight>>{
	
	@Override
	public List<Flight> create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		
		List<Flight> flightsList = new ArrayList<>();
		resultSet.beforeFirst();
		
		while(resultSet.next()) {
			
			flightsList.add(createFlight(resultSet));
		}
		
		return flightsList;
	}
}
