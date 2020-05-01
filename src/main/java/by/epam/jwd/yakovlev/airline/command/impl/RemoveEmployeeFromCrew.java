package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.CrewService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class RemoveEmployeeFromCrew extends Command{
	
	private static final Logger LOGGER = Logger.getLogger(RemoveEmployeeFromCrew.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		CrewService crewService = ServiceFactory.INSTANCE.getCrewService();
		HttpSession session = request.getSession();
		
		String employeeIDString = request.getParameter(StringConstant.EMPLOYEE_ID_KEY.getValue());
		String flightIDString = request.getParameter(StringConstant.FLIGHT_ID_KEY.getValue());
		
		int employeeID = parseStringToIntOrElseZero(employeeIDString);
		int flightID = parseStringToIntOrElseZero(flightIDString);
		
		try {
			crewService.deleteCrewMember(flightID, employeeID);
		} catch (ServiceException e) {
			LOGGER.debug("Fail remove employee");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail remove crew member");
		}
		
		refreshSelectedFlightCrew(session);
		
		return getNextPage(session).getPageURL();
	}
}
