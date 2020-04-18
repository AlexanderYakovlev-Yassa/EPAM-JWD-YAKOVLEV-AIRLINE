package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

public class Logout implements Command {

	private static final Logger LOGGER = Logger.getLogger(Logout.class);
	private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String nickname = null;

		char[] passwordSequence = null;
		
		Optional<Employee> optionalEmployee = Optional.empty();

		LOGGER.debug("User name - " + nickname);

		try {
			optionalEmployee = EMPLOYEE_SERVICE.login(nickname, passwordSequence);
		} catch (ServiceException e) {
			LOGGER.debug("Service failed " + e.getMessage());
			response.sendError(503, "Service unavailable");
		}

		Employee employee = optionalEmployee.orElse(null);

		LOGGER.debug("Session employee will be - " + employee.getFirstName() + " " + employee.getLastName());

		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), employee);
		return PageEnum.INDEX.getPageURL();
	}
}
