package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import java.util.Map;

import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.AbstractCommandEntityFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandAirportFactory extends AbstractCommandEntityFactory<Airport>{
	
	private static final int ZERO_INDEX = 0;

	@Override
	public Airport create(Map<String, String[]> map) throws EntityFactoryException {
		
		Airport airport = new Airport();
		
		airport.setAirportID(parseToPositiveIntOrElseZero(map.get(StringConstant.AIRPORT_ID_KEY.getValue())[ZERO_INDEX]));		
		airport.setAirportCity(map.get(StringConstant.AIRPORT_CITY_KEY.getValue())[ZERO_INDEX]);
		
		return airport;
	}
}
