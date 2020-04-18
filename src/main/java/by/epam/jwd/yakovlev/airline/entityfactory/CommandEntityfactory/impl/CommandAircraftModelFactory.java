package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl;

import java.util.Map;
import java.util.Optional;

import org.hamcrest.core.StringContains;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandAircraftModelFactory implements CommandEntityFactory{

	@Override
	public Optional<Object> create(Map<String, String[]> map) throws EntityFactoryException {
		
		
		AircraftModel aircraftModel = new AircraftModel();
		
		aircraftModel.setAircraftModelID(Integer.parseInt(map.get(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue())[0]));
		aircraftModel.setAircraftModelCapacity(Integer.parseInt(map.get(StringConstant.AIRCRAFT_MODEL_CAPACITY_KEY.getValue())[0]));
		aircraftModel.setAircraftModelName(map.get(StringConstant.AIRCRAFT_MODEL_NAME_KEY.getValue())[0]);
		
		return Optional.of(aircraftModel);
	}
}
