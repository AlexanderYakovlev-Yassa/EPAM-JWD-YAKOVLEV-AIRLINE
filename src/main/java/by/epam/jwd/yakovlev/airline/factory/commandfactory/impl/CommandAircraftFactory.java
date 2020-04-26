package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.AbstractCommandEntityFactory;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandAircraftFactory extends AbstractCommandEntityFactory<Aircraft>{
	
	private static final Logger LOGGER = Logger.getLogger(CommandAircraftFactory.class);
	private static final int ZERO_INDEX = 0;

	@Override
	public Aircraft create(Map<String, String[]> map) throws EntityFactoryException {
		
		Aircraft aircraft = new Aircraft();
		
		aircraft.setAircraftID
		(parseToPositiveIntOrElseZero(map.get(StringConstant.AIRCRAFT_ID_KEY.getValue())[ZERO_INDEX]));	
		
		aircraft.setAircraftSideNumber(map.get(StringConstant.AIRCRAFT_SIDE_NUMBER_KEY.getValue())[ZERO_INDEX]);
		
		int aircraftModelID = parseToPositiveIntOrElseZero(map.get(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue())[ZERO_INDEX]);
		
		try {
			ServiceFactory.INSTANCE.getAircraftModelService().getAircraftModelByID(aircraftModelID).ifPresent(aircraft::setAircraftModel);
		} catch (ServiceException e) {
			LOGGER.debug("Fail get aircraft model", e);
		}		
		
		return aircraft;
	}
}
