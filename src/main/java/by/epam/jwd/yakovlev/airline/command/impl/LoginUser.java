package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandDefaultEmployeeFactory;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginUser extends Command {

	private static final Logger LOGGER = Logger.getLogger(LoginUser.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		EmployeeService service = ServiceFactory.INSTANCE.getEmployeeService();
		CommandDefaultEmployeeFactory defaultEmployeeFactory = CommandEntityFactory.getInstance().getDefaultEmployeeFactory();
		
		Employee employee = defaultEmployeeFactory.getDefaultEmployee();
		
		String nickname = request.getParameter(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue());
		char[] passwordSequence = request.getParameter(StringConstant.EMPLOYEE_PASSWORD_KEY.getValue()).toCharArray();

		try {
			employee = service.login(nickname, passwordSequence).orElse(employee);			
		} catch (ServiceException e) {
			LOGGER.debug("Service failed " + e.getMessage());
		}

		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), employee);

		return PageEnum.INDEX.getPageURL();
	}
}
