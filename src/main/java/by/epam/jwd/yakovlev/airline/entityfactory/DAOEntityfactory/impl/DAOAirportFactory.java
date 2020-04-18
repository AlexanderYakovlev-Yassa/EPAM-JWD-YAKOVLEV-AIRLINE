package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOAirportFactory implements DAOEntityFactory{

	@Override
	public Optional<Object> make(ResultSet resultSet) throws SQLException {
		
		Airport airport = new Airport();
		
		airport.setAirportID(resultSet.getInt(StringConstant.AIRPORT_ID_KEY.getValue()));
		airport.setAirportCity(resultSet.getString(StringConstant.AIRPORT_CITY_KEY.getValue()));
		
		return Optional.of(airport);		
	}
}
