package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.EntityFactoryTypesEnum;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;

public class UpdateAircraftModel implements Command{

	private static final Logger LOGGER = Logger.getLogger(UpdateAircraftModel.class);
	private static final CommandEntityFactory AIRCRAFT_MODEL_FACTORY = EntityFactoryTypesEnum.AIRCRAFT_MODEL.getConcreatEntityFactory();
	private static final AircraftService AIRCRAFT_SERVICE = ServiceFactory.INSTANCE.getAircraftService();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();

		Optional<Object> aircraftModelOptional = Optional.empty();

		try {
			aircraftModelOptional = AIRCRAFT_MODEL_FACTORY.create(map);
		} catch (EntityFactoryException e) {			
			LOGGER.debug("Fail create an aircraft model because " + e.getMessage());
			session.setAttribute("warning_message", "Fail execute such updates.");
			return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
		}
		
		try {
			AIRCRAFT_SERVICE.updateAircraftModel(aircraftModelOptional);
			session.setAttribute("success_message", "The aircrat model was updated successfully");
            session.setAttribute("all_aircraft_models_list", AIRCRAFT_SERVICE.getAllAircraftModelsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail update the aircraft model because " + e.getMessage());
			session.setAttribute("warning_message", "Fail update aircraft model.");
		}
		
		return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
	}
}
