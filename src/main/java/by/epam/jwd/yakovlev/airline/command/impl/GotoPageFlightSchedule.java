package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;

public class GotoPageFlightSchedule extends AbstractCommand{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
		refreshAllFlightsList(session);
		
		return PageEnum.FLIGHT_SCHEDULE.getPageURL();
	}
}
