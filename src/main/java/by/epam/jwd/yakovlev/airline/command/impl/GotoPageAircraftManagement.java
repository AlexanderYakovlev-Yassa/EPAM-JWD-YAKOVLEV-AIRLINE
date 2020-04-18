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
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AircraftService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class GotoPageAircraftManagement implements Command{

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		AircraftService AIRCRAFT_SERVICE = ServiceFactory.INSTANCE.getAircraftService();

		HttpSession session = request.getSession();
		
		try {
			List<Aircraft> aircraftsList = AIRCRAFT_SERVICE.getAllAircraftsList();
			List<AircraftModel> aircraftModelsList = AIRCRAFT_SERVICE.getAllAircraftModelsList();
			session.setAttribute(StringConstant.ALL_AIRCRAFTS_LIST_KEY.getValue(), aircraftsList);
			session.setAttribute(StringConstant.ALL_AIRCRAFT_MODELS_LIST_KEY.getValue(), aircraftModelsList);
		} catch (ServiceException e) {
			response.sendError(503, "Servis is unavailable");
		}
		
		return PageEnum.AIRCRAFT_MANAGEMENT.getPageURL();
	}

}
