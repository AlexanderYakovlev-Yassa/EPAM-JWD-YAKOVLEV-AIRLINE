package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.CommandResultStatusEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.ResourceManager;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DeleteEmployee implements Command{
	
	private static final Logger LOGGER = Logger.getLogger(DeleteEmployee.class);
    private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();
    private static final ResourceManager RESOURCE_MANAGER = ResourceManager.INSTANCE;


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String employeeId = request.getParameter(StringConstant.EMPLOYEE_ID_KEY.getValue());					
		
		if (employeeId == null) {		
			LOGGER.debug("null employee");
			CommandResultStatusEnum.EMPLOYEE_NOT_SELECTED.setMessage(session, false);
			return PageEnum.EMPLOYEE.getPageURL();
		}
		
		Optional<String> employeeIdOptional = Optional.of(employeeId);
		boolean successFlag = false;
			
		try {
			successFlag = EMPLOYEE_SERVICE.deleteEmployee(employeeIdOptional);
			session.setAttribute(StringConstant.ALL_EMPLOYEE_LIST_KEY.getValue(),
                    EMPLOYEE_SERVICE.getAllEmployeeList());			
			LOGGER.debug("delete success");
			LOGGER.debug("successFlag=" + successFlag);
		} catch (ServiceException e) {
			LOGGER.debug("delete fault");
			CommandResultStatusEnum.EMPLOYEE_DELETE.setMessage(session, false);
			return PageEnum.EMPLOYEE.getPageURL();
		}
		
		LOGGER.debug("delete final status is " + successFlag);
		CommandResultStatusEnum.EMPLOYEE_DELETE.setMessage(session, successFlag);
		
		return PageEnum.EMPLOYEE.getPageURL();
	}

}
