package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;

public class DAOAirportsListFactory extends AbstractDAOFactory<List<Airport>>{
	
	@Override
	public List<Airport> create(ResultSet resultSet) throws SQLException, DaoFactoryException {
		
		checkResultSetForNull(resultSet);
		
		List<Airport> airportsList = new ArrayList<>();
		resultSet.beforeFirst();;
		
		while(resultSet.next()) {
			
			airportsList.add(createAirport(resultSet));
		}
		
		return airportsList;
	}
}
