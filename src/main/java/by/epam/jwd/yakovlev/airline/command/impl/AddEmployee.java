package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandEmployeeFactory;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class AddEmployee extends Command {

	private static final Logger LOGGER = Logger.getLogger(AddEmployee.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();
		EmployeeService service = ServiceFactory.INSTANCE.getEmployeeService();
		CommandEmployeeFactory factory = CommandEntityFactory.getInstance().getEmployeeFactory();

		Employee employee = null;
		
		try {
			employee = factory.create(map);
			service.addEmployee(employee);
			refreshAllEmployeesList(session);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "Add success");
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("Fail add an employee", e);
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Add fail");
		}

		return PageEnum.EMPLOYEE.getPageURL();
	}
}
