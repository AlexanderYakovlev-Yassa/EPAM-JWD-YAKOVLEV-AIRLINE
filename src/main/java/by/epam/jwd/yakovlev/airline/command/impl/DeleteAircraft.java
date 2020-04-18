package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.CommandResultStatusEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.ResourceManager;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

public class DeleteAircraft implements Command {
	
	private static final Logger LOGGER = Logger.getLogger(DeleteAircraft.class);
    private static final AircraftService AIRCRAFT_SERVICE = ServiceFactory.INSTANCE.getAircraftService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();
		String aircraftId = request.getParameter(StringConstant.AIRCRAFT_ID_KEY.getValue());					
		
		if (aircraftId == null) {		
			LOGGER.debug("null aircraft");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Pick the aircraft");;
			return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
		}
		
		Optional<String> aircraftIdOptional = Optional.of(aircraftId);
		boolean successFlag = false;
			
		try {
			successFlag = AIRCRAFT_SERVICE.deleteAircraft(aircraftIdOptional);
			session.setAttribute(StringConstant.ALL_AIRCRAFTS_LIST_KEY.getValue(),
                    AIRCRAFT_SERVICE.getAllAircraftsList());			
			LOGGER.debug("delete success");
			LOGGER.debug("successFlag=" + successFlag);
		} catch (ServiceException e) {
			LOGGER.debug("delete fault");
			CommandResultStatusEnum.EMPLOYEE_DELETE.setMessage(session, false);
			return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
		}
		
		LOGGER.debug("delete final status is " + successFlag);
		CommandResultStatusEnum.EMPLOYEE_DELETE.setMessage(session, successFlag);
    	
        return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
    }
}
