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
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.EntityFactoryTypesEnum;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class AddEmployee implements Command {

	private static final Logger LOGGER = Logger.getLogger(AddEmployee.class);
	private static final CommandEntityFactory COMMAND_EMPLOYEE_FACTORY = EntityFactoryTypesEnum.EMPLOYEE.getConcreatEntityFactory();
	private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map<String, String[]> map = request.getParameterMap();
		HttpSession session = request.getSession();

		Optional<Object> employeeOptional = Optional.empty();

		try {
			employeeOptional = COMMAND_EMPLOYEE_FACTORY.create(map);
		} catch (EntityFactoryException e) {
			LOGGER.debug("Fail create an employee because " + e.getMessage());
		}
		
		try {
			EMPLOYEE_SERVICE.addEmployee(employeeOptional);
			session.setAttribute(StringConstant.ALL_EMPLOYEE_LIST_KEY.getValue(),
                    EMPLOYEE_SERVICE.getAllEmployeeList());
		} catch (ServiceException e) {
			LOGGER.debug("Fail add an employee");
		}

		return PageEnum.EMPLOYEE.getPageURL();
	}

}
