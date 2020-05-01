package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.LocalisationEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandDefaultEmployeeFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Initialise extends Command {

    private static final Logger LOGGER = Logger.getLogger(Initialise.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	CommandDefaultEmployeeFactory factory = CommandEntityFactory.getInstance().getDefaultEmployeeFactory();
    	Employee unregisteredUser = factory.getDefaultEmployee();
    	
    	LOGGER.debug("INITIALISATION");

        HttpSession session = request.getSession();
        
        if (session.getAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue()) == null) {
		session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), unregisteredUser);
        }
        
        session.setAttribute(StringConstant.LANGUAGE_KEY.getValue(), LocalisationEnum.EN.getLocalisation());

        return PageEnum.INDEX.getPageURL();
    }
}
