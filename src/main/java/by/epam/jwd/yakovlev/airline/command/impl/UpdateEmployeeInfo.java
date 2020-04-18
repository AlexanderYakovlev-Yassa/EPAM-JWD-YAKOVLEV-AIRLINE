package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl.CommandEmployeeFactory;
import by.epam.jwd.yakovlev.airline.exception.CommandException;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class UpdateEmployeeInfo implements Command{
	
    private static final Logger LOGGER = Logger.getLogger(LoginUser.class);
	private static final CommandEmployeeFactory COMMAND_EMPLOYEE_FACTORY = new CommandEmployeeFactory();
    private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, String[]> map = request.getParameterMap();

		Optional<Object> objectOptional = Optional.empty();

		try {
			objectOptional = COMMAND_EMPLOYEE_FACTORY.create(map);
		} catch (EntityFactoryException e) {
			LOGGER.debug("Fail create an employee because " + e.getMessage());
		}
		
		try {
			EMPLOYEE_SERVICE.updateEmployeeInfo(objectOptional);
		} catch (ServiceException e) {
			LOGGER.debug("Fail update the employee info");
			throw new CommandException("Fail update the employee info", e);
		}
		
		HttpSession session = request.getSession();
		
		Employee employee = getCurrentUser(session);
		
		int id = employee != null ? employee.getId() : 0;
		
		LOGGER.debug("the session current employee id - " + id);
		
		try {
			Optional<Employee> employeeOptional = EMPLOYEE_SERVICE.getEmployeeById(id);
			LOGGER.debug("Optional<Employee> - " + employeeOptional.isPresent());
			employee = employeeOptional.orElse(employee);
			LOGGER.debug("the session current employee - " + employee.getFirstName() + " " + employee.getLastName());
		} catch (ServiceException e) {
			LOGGER.debug("Fail the session current employee");
			throw new CommandException("Fail the session current employee", e);
		}
		
		session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), employee);
		
		
		
		return PageEnum.CABINET.getPageURL();
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
