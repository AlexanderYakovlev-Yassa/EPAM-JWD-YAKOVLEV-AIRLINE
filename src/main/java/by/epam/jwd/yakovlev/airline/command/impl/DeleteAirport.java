package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DeleteAirport implements Command{
	
	private static final Logger LOGGER = Logger.getLogger(DeleteAirport.class);
    private static final AirportService AIRPORT_SERVICE = ServiceFactory.INSTANCE.getAirportService();
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();
		String airportId = request.getParameter(StringConstant.AIRPORT_ID_KEY.getValue());					
		
		if (airportId == null) {		
			LOGGER.debug("null airport");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Pick the airport");
			return PageEnum.AIRPORT_MANAGEMENT.getPageURL();
		}
		
		Optional<String> airportIdOptional = Optional.of(airportId);
			
		try {
			AIRPORT_SERVICE.deleteAirport(airportIdOptional);
			session.setAttribute(StringConstant.ALL_AIRPORTS_LIST_KEY.getValue(),
                    AIRPORT_SERVICE.getAllAirportList());
			LOGGER.debug("delete success");
		} catch (ServiceException e) {
			LOGGER.debug("delete fault");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail delete");;
			return PageEnum.AIRPORT_MANAGEMENT.getPageURL();
		}
		
		session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "Delete success");
    	
        return PageEnum.AIRPORT_MANAGEMENT.getPageURL();
    }
}
