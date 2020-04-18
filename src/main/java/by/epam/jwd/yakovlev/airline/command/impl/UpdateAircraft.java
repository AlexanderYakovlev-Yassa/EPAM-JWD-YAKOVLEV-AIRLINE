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

public class UpdateAircraft implements Command{
	
	private static final Logger LOGGER = Logger.getLogger(AddAircraft.class);
	private static final CommandEntityFactory AIRCRAFT_FACTORY = EntityFactoryTypesEnum.AIRCRAFT.getConcreatEntityFactory();
	private static final AircraftService AIRCRAFT_SERVICE = ServiceFactory.INSTANCE.getAircraftService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();

		Optional<Object> aircraftOptional = Optional.empty();

		try {
			aircraftOptional = AIRCRAFT_FACTORY.create(map);
		} catch (EntityFactoryException e) {			
			LOGGER.debug("Fail create an aircraft because " + e.getMessage());
			session.setAttribute("warning_message", "Fail execute such updates.");
			return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
		}
		
		try {
			AIRCRAFT_SERVICE.updateAircraft(aircraftOptional);
			session.setAttribute("success_message", "The aircrat was updated successfully");
            session.setAttribute("all_aircrafts_list", AIRCRAFT_SERVICE.getAllAircraftsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail update the aircraft because " + e.getMessage());
			session.setAttribute("warning_message", "Fail update aircraft.");
		}
		
		return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
	}
}
