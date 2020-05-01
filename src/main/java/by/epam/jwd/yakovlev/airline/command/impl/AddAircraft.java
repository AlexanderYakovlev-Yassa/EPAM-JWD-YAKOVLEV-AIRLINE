package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandAircraftFactory;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class AddAircraft extends Command {
	
	private static final Logger LOGGER = Logger.getLogger(AddAircraft.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();
		AircraftService service = ServiceFactory.INSTANCE.getAircraftService();
		CommandAircraftFactory factory = CommandEntityFactory.getInstance().getAircraftFactory();

		Aircraft aircraft = null;
		
		try {
			aircraft = factory.create(map);
			service.addAircraft(aircraft);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "The aircrat was added successfully");
            refreshAllAircraftsList(session);
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("Fail add the aircraft", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail add aircraft.");
		}
		
		return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
    }
}
