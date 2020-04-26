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
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class AddAircraftModel implements Command{
	
	private static final Logger LOGGER = Logger.getLogger(AddAircraftModel.class);

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();
		AircraftModelService service = ServiceFactory.INSTANCE.getAircraftModelService();
		CommandAircraftModelFactory factory = CommandEntityFactory.getInstance().getAircraftModelFactory();

		AircraftModel aircraftModel = null;
		
		try {
			aircraftModel = factory.create(map);
			service.addAircraftModel(aircraftModel);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(),
					"The aircrat model was added successfully");
            session.setAttribute("all_aircraft_models_list", service.getAllAircraftModelsList());
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("Fail add the aircraft model because", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(),
					"Fail add aircraft model.");
		}
		
		return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
    }	
}
