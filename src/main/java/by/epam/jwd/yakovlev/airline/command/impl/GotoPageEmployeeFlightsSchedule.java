package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.FlightService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class GotoPageEmployeeFlightsSchedule extends AbstractCommand {

	private FlightService flightService = ServiceFactory.INSTANCE.getFlightService();
	private EmployeeService employeeService = ServiceFactory.INSTANCE.getEmployeeService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();

		String selectedEmployeeIDString = request.getParameter(StringConstant.EMPLOYEE_ID_KEY.getValue());
		Integer selectedEmployeeID = parseStringToIntOrElseZero(selectedEmployeeIDString);
		Optional<Employee> selectedEmployeeOptional = Optional.empty();
		Employee selectedEmployee = null;

		try {
			selectedEmployeeOptional = employeeService.getEmployeeById(selectedEmployeeID);
			if (selectedEmployeeOptional.isPresent()) {
				selectedEmployee = selectedEmployeeOptional.get();
				selectedEmployeeID = selectedEmployee.getId();
			}

			session.setAttribute(StringConstant.SELECTED_EMPLOYEE.getValue(), selectedEmployee);
			session.setAttribute(StringConstant.FLIGHTS_FOR_SELECTED_EMPLOYEE.getValue(),
					flightService.getFlightsListByEmployeeID(selectedEmployeeID));
		} catch (ServiceException e) {
			session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), "Fail get the list of flights");
		}

		return PageEnum.EMPLOYEE_FLIGHTS_SCHEDULE.getPageURL();
	}
}
