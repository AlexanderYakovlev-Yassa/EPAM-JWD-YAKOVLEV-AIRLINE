package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.util.CommandUtil;

public class GotoPageFlightsManagement implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {		

		CommandUtil util = CommandUtil.getINSTANCE();
		HttpSession session = request.getSession();
		
		util.refreshAllFlightsList(session);
		util.refreshAllAircraftsList(session);
		util.refreshAllAirportsList(session);
		
		return PageEnum.FLIGHTS_MANAGEMENT.getPageURL();
	}
}
