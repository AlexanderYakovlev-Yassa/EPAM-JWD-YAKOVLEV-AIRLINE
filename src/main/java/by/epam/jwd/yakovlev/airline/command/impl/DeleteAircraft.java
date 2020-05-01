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

public class DeleteAircraft extends Command {
	
	private static final Logger LOGGER = Logger.getLogger(DeleteAircraft.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();
    	Map<String, String[]> map = request.getParameterMap();
		AircraftService service = ServiceFactory.INSTANCE.getAircraftService();
		CommandAircraftFactory factory = CommandEntityFactory.getInstance().getAircraftFactory();
						
		Aircraft aircraft = null;
			
		try {
			aircraft = factory.create(map);
			service.deleteAircraft(aircraft);
			refreshAllAircraftsList(session);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(),
					"The flight added successfully");
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("delete fault", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(),
					"Fail delete the aircraft.");
			return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
		}
    	
        return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
    }
}
