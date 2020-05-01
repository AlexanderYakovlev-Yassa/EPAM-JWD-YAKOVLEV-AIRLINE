package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandAirportFactory;
import by.epam.jwd.yakovlev.airline.service.AirportService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DeleteAirport extends Command{
	
	private static final Logger LOGGER = Logger.getLogger(DeleteAirport.class);
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();
    	Map<String, String[]> map = request.getParameterMap();
		AirportService service = ServiceFactory.INSTANCE.getAirportService();
		CommandAirportFactory factory = CommandEntityFactory.getInstance().getAirportFactory();
						
		Airport airport = null;		
		
		try {
			airport = factory.create(map);
			service.deleteAirport(airport);
			session.setAttribute(StringConstant.ALL_AIRPORTS_LIST_KEY.getValue(),
                    service.getAllAirportsList());
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "Delete success");
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("delete fault", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail delete");
		}
		
        return PageEnum.AIRPORT_MANAGEMENT.getPageURL();
    }
}
