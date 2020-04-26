package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOAirportFactory extends AbstractDAOFactory<Airport>{
	
	@Override
	public Airport create(ResultSet resultSet) throws SQLException {
		
		Airport airport = new Airport();
		
		airport.setAirportID(resultSet.getInt(StringConstant.AIRPORT_ID_KEY.getValue()));
		airport.setAirportCity(resultSet.getString(StringConstant.AIRPORT_CITY_KEY.getValue()));
		
		return airport;
	}
}
