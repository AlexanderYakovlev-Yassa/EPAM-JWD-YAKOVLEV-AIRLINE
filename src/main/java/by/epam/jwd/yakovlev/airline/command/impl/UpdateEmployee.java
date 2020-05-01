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
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandDefaultEmployeeFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandEmployeeFactory;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class UpdateEmployee extends Command {

	private static final Logger LOGGER = Logger.getLogger(UpdateEmployee.class);
	private static final EmployeeService SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, String[]> map = request.getParameterMap();
		CommandEmployeeFactory factory = CommandEntityFactory.getInstance().getEmployeeFactory();		
		HttpSession session = request.getSession();
		
		Employee employee = null;

		try {
			employee = factory.create(map);
			SERVICE.updateEmployee(employee);			
			updateCurrentSessionEmployee(session);
			refreshAllEmployeesList(session);
			session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), "Update success");
		} catch (ServiceException | EntityFactoryException e) {
			LOGGER.debug("Fail update the employee info");
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Update fail");
		}
		
		return getNextPage(session).getPageURL();
	}

	private void updateCurrentSessionEmployee(HttpSession session) {

		CommandDefaultEmployeeFactory defaultEmployeeFactory = CommandEntityFactory.getInstance()
				.getDefaultEmployeeFactory();

		Employee employee = null;
		Employee defaultEmployee = defaultEmployeeFactory.getDefaultEmployee();

		Employee currentEmployee = getCurrentUser(session);

		int id = (currentEmployee != null) ? currentEmployee.getId() : 0;

		LOGGER.debug("the current session employee id - " + id);

		try {
			employee = SERVICE.getEmployeeById(id).orElse(defaultEmployee);
			LOGGER.debug("employee name " + employee.getLastName());
		} catch (ServiceException e) {
			LOGGER.debug("Fail the session current employee");			
		}

		session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), employee);
	}

	private Employee getCurrentUser(HttpSession session) {

		Employee employee = null;

		Object o = session.getAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue());

		if (o != null && o.getClass() == Employee.class) {

			employee = (Employee) o;
		}

		return employee;
	}
}
