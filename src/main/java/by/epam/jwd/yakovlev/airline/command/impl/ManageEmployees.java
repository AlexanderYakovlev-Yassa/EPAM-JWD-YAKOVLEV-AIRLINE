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
import java.io.IOException;

public class ManageEmployees implements Command {

    private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            HttpSession session = request.getSession();
            session.setAttribute(StringConstant.ALL_EMPLOYEE_LIST_KEY.getValue(),
                    EMPLOYEE_SERVICE.getAllEmployeeList());
            session.setAttribute(StringConstant.ALL_SYSTEM_ROLE_LIST_KEY.getValue(),
                    EMPLOYEE_SERVICE.getAllSystemRoleList());
            session.setAttribute(StringConstant.ALL_CREW_ROLE_LIST_KEY.getValue(),
                    EMPLOYEE_SERVICE.getAllCrewRole());
        } catch (ServiceException e) {
            response.sendError(503, "Service temporary unavailable.");
        }

        return PageEnum.EMPLOYEE.getPageURL();
    }
}
