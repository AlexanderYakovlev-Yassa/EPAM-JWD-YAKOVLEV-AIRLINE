package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.CommandResultStatusEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DeleteAircraftModel implements Command{
	
	private static final Logger LOGGER = Logger.getLogger(DeleteAircraftModel.class);
    private static final AircraftService AIRCRAFT_SERVICE = ServiceFactory.INSTANCE.getAircraftService();
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();
		String aircraftModelId = request.getParameter(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue());					
		
		if (aircraftModelId == null) {		
			LOGGER.debug("null aircraft model");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Pick the aircraft model");
			return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
		}
		
		Optional<String> aircraftModelIdOptional = Optional.of(aircraftModelId);
		boolean successFlag = false;
			
		try {
			successFlag = AIRCRAFT_SERVICE.deleteAircraftModel(aircraftModelIdOptional);
			session.setAttribute(StringConstant.ALL_AIRCRAFT_MODELS_LIST_KEY.getValue(),
                    AIRCRAFT_SERVICE.getAllAircraftModelsList());
			LOGGER.debug("delete success");
		} catch (ServiceException e) {
			LOGGER.debug("delete fault");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail delete");;
			return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
		}
		
		session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "Delete success");
    	
        return PageEnum.AIRCRAFT_MODELS_MANAGEMENT.getPageURL();
    }
}
