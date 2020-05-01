package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandAircraftModelFactory;
import by.epam.jwd.yakovlev.airline.service.AircraftModelService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;

public class UpdateAircraftModel extends Command{

	private static final Logger LOGGER = Logger.getLogger(UpdateAircraftModel.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();
		AircraftModelService service = ServiceFactory.INSTANCE.getAircraftModelService();
		CommandAircraftModelFactory factory = CommandEntityFactory.getInstance().getAircraftModelFactory();

		AircraftModel aircraftModel = null;

		try {
			aircraftModel = factory.create(map);
		} catch (EntityFactoryException e) {			
			LOGGER.debug("Fail create an aircraft model because " + e.getMessage());
			session.setAttribute("warning_message", "Fail create aircraft model.");
			return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
		}
		
		try {
			service.updateAircraftModel(aircraftModel);
			session.setAttribute("success_message", "The aircrat model was updated successfully");
            session.setAttribute("all_aircraft_models_list", service.getAllAircraftModelsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail update the aircraft model because " + e.getMessage());
			session.setAttribute("warning_message", "Fail update aircraft model.");
		}
		
		return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
	}
}
