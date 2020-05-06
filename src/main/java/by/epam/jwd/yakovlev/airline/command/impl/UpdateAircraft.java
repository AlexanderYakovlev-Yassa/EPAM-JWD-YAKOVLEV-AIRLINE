package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandAircraftFactory;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class UpdateAircraft extends AbstractCommand{
	
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
			service.updateAircraft(aircraft);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(),
					"The aircrat was updated successfully");
            refreshAllAircraftsList(session);
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("Fail update the aircraft", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail update aircraft.");
		}
		
		return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
	}
}
