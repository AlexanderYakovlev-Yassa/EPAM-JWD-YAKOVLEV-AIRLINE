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
import by.epam.jwd.yakovlev.airline.util.CommandUtil;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DeleteAircraftModel implements Command{
	
	private static final Logger LOGGER = Logger.getLogger(DeleteAircraftModel.class);
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();
    	Map<String, String[]> map = request.getParameterMap();
    	AircraftModelService service = ServiceFactory.INSTANCE.getAircraftModelService();
		CommandAircraftModelFactory factory = CommandEntityFactory.getInstance().getAircraftModelFactory();
		CommandUtil util = CommandUtil.getINSTANCE();
		
		AircraftModel aircraftModel = null;
			
		try {
			aircraftModel = factory.create(map);
			service.deleteAircraftModel(aircraftModel);
			util.refreshAllAircraftModelsList(session);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "Delete success");
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("delete fault", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail delete");
		}
		
        return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
    }
}
