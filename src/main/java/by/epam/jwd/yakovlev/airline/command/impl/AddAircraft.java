package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.CommandResultStatusEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.EntityFactoryTypesEnum;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl.CommandEmployeeFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class AddAircraft implements Command {
	
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
			session.setAttribute("warning_message", "Fail create aircraft.");
			return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
		}
		
		try {
			AIRCRAFT_SERVICE.addAircraft(aircraftOptional);
			session.setAttribute("success_message", "The aircrat was added successfully");
            session.setAttribute("all_aircrafts_list", AIRCRAFT_SERVICE.getAllAircraftsList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail add the aircraft because " + e.getMessage());
			session.setAttribute("warning_message", "Fail add aircraft.");
		}
		
		return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
    }
}
