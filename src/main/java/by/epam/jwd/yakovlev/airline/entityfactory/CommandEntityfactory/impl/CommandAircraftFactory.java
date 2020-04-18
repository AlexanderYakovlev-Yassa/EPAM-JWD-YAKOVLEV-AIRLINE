package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl;

import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandAircraftFactory implements CommandEntityFactory {

	private static final Logger LOGGER = Logger.getLogger(CommandAircraftFactory.class);
	private static final AircraftService AIRCRAFT_SERVICE = ServiceFactory.INSTANCE.getAircraftService();
	private static final  String[] DEFAULT_MAP_ATTRIBUTE_VALUE = {"0"};

	@Override
	public Optional<Object> create(Map<String, String[]> map) throws EntityFactoryException {

		Aircraft aircraft = new Aircraft();

		aircraft.setAircraftID(parseToIntID(map.getOrDefault(StringConstant.AIRCRAFT_ID_KEY.getValue(), DEFAULT_MAP_ATTRIBUTE_VALUE)[0]));
		aircraft.setAircraftSideNumber(map.get(StringConstant.AIRCRAFT_SIDE_NUMBER_KEY.getValue())[0]);

		
		
		int modelID = parseToIntID(map.getOrDefault(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue(), DEFAULT_MAP_ATTRIBUTE_VALUE)[0]);
		
		try {
			AIRCRAFT_SERVICE.getAircraftModelByID(modelID).ifPresent(aircraft::setAircraftModel);
		} catch (ServiceException e) {
			LOGGER.debug("Fail get an aircraft model");
		}
		
		return Optional.of(aircraft);
	}
}
