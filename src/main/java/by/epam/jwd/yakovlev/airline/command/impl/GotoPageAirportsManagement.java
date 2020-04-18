package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class GotoPageAirportsManagement implements Command{

	private static final AirportService AIRPORT_SERVICE = ServiceFactory.INSTANCE.getAirportService();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		

		HttpSession session = request.getSession();
		
		try {
			List<Airport> airportsList = AIRPORT_SERVICE.getAllAirportList();
			session.setAttribute(StringConstant.ALL_AIRPORTS_LIST_KEY.getValue(), airportsList);
		} catch (ServiceException e) {
			response.sendError(503, "Servis is unavailable");;
		}
		
		return PageEnum.AIRPORT_MANAGEMENT.getPageURL();
	}
}
