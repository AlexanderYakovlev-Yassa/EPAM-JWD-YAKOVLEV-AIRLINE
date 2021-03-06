package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.CrewService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class AddEmployeeToCrew extends AbstractCommand{
	
	private static final Logger LOGGER = Logger.getLogger(AddEmployeeToCrew.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		CrewService crewService = ServiceFactory.INSTANCE.getCrewService();
		HttpSession session = request.getSession();
		
		String employeeIDString = request.getParameter(StringConstant.EMPLOYEE_ID_KEY.getValue());
		String flightIDString = request.getParameter(StringConstant.FLIGHT_ID_KEY.getValue());
		
		int employeeID = parseStringToIntOrElseZero(employeeIDString);
		int flightID = parseStringToIntOrElseZero(flightIDString);
		
		try {
			crewService.addCrewMember(flightID, employeeID);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "Member added to the crew successfully");
		} catch (ServiceException e) {
			LOGGER.debug("Fail get employee");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail add member to the crew");
		}
		
		refreshSelectedFlightCrew(session);
		
		return getNextPage(session).getPageURL();
	}
}
