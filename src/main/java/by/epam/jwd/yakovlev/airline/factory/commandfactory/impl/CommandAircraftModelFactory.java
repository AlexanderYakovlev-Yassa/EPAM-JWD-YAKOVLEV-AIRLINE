package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import java.util.Map;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.AbstractCommandEntityFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandAircraftModelFactory extends AbstractCommandEntityFactory<AircraftModel>{
	
	private static final int ZERO_INDEX = 0;

	@Override
	public AircraftModel create(Map<String, String[]> map) throws EntityFactoryException {
		
		AircraftModel aircraftModel = new AircraftModel();
		
		aircraftModel.setAircraftModelID
		(parseToPositiveIntOrElseZero(map.get(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue())[ZERO_INDEX]));	
		
		aircraftModel.setAircraftModelName(map.get(StringConstant.AIRCRAFT_MODEL_NAME_KEY.getValue())[ZERO_INDEX]);
		
		aircraftModel.setAircraftModelCapacity
		(parseToPositiveIntOrElseZero(map.get(StringConstant.AIRCRAFT_MODEL_CAPACITY_KEY.getValue())[ZERO_INDEX]));			
		
		return aircraftModel;
	}
}
