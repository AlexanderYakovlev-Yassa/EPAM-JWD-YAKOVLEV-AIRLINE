package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl;

import java.util.Map;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandAirportFactory implements CommandEntityFactory{

	@Override
	public Optional<Object> create(Map<String, String[]> map) throws EntityFactoryException {
		
		Airport airport = new Airport();
		
		airport.setAirportID(parseToIntID(map.get(StringConstant.AIRPORT_ID_KEY.getValue())[0]));		
		airport.setAirportCity(map.get(StringConstant.AIRPORT_CITY_KEY.getValue())[0]);
		
		return Optional.of(airport);
	}

}
