package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ServiceIsUnavailableException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class Initialise implements Command {

    private static final Logger LOGGER = Logger.getLogger(Initialise.class);
    private static EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	
    	LOGGER.debug("INITIALISATION");

        HttpSession session = request.getSession();
        Optional<Employee> employeeOptional = Optional.empty();
        
        try {
			employeeOptional = EMPLOYEE_SERVICE.login(null, null);
		} catch (ServiceException e) {
			LOGGER.debug("Fail initialise application");
			throw new ServiceIsUnavailableException();
		}
        
        Employee employee = employeeOptional.orElse(null);
        
        session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), employee);
		
        String nextPage = PageEnum.INDEX.getPageURL();

        return nextPage;
    }
}
