package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandEmployeeFactory;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.CommandUtil;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class UpdatePassword implements Command{
	
    private static final Logger LOGGER = Logger.getLogger(LoginUser.class);    

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		EmployeeService service = ServiceFactory.INSTANCE.getEmployeeService();
		HttpSession session = request.getSession();
		Map<String, String[]> map = request.getParameterMap();
		CommandEmployeeFactory factory = CommandEntityFactory.getInstance().getEmployeeFactory();
		CommandUtil util = CommandUtil.getINSTANCE();
		
		Employee employee = null;
		
		try {			
			employee = factory.create(map);
			char[] password = request.getParameter(StringConstant.EMPLOYEE_PASSWORD_KEY.getValue()).toCharArray();
			service.updatePassword(employee, password);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(),
					"Password updated successfully");
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("Fail chage the password of the null login name employee");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(),
					"Faile update password");
		}
				
		return util.getNextPage(request.getSession()).getPageURL();
	}
}
