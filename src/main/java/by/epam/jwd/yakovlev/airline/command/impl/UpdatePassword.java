package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.exception.CommandException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class UpdatePassword implements Command{
	
    private static final Logger LOGGER = Logger.getLogger(LoginUser.class);
    private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Optional<String> employeeIdOptional = Optional.ofNullable(request.getParameter(StringConstant.EMPLOYEE_ID_KEY.getValue()));
				
		Optional<char[]> passwordSequenceOptional = Optional.of(
				request.getParameter(StringConstant.EMPLOYEE_PASSWORD_KEY.getValue()).toCharArray());		
		
		try {
			EMPLOYEE_SERVICE.updatePassword(employeeIdOptional, passwordSequenceOptional);
		} catch (ServiceException e) {
			LOGGER.debug("Fail chage the password of the null login name employee");
			throw new CommandException("Fail chage the password of the null login name employee", e);
		}
				
		return PageEnum.EMPLOYEE.getPageURL();
	}
}
