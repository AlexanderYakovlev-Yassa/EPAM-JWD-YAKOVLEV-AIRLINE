package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class LoginUser implements Command {

    private static final Logger LOGGER = Logger.getLogger(LoginUser.class);
    private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        LOGGER.debug("Came to login user");

        HttpSession session = request.getSession();

        String nickname = request.getParameter(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue());

        char[] passwordHashSequence = request.
                getParameter(StringConstant.EMPLOYEE_PASSWORD_KEY.getValue()).toCharArray();

        Optional<Employee> optionalEmployee = Optional.empty();

        LOGGER.debug("User name - " + nickname);

        try {
            optionalEmployee = EMPLOYEE_SERVICE.login(nickname, passwordHashSequence);
        } catch (ServiceException e) {
            LOGGER.debug("Service failed " + e.getMessage());
            response.sendError(503, "Service unavailable");
        }

        LOGGER.debug("Optional employee is present - " + optionalEmployee.isPresent());

        if (!optionalEmployee.isPresent()) {
            request.setAttribute("login_status", "Login fail");
            return PageEnum.LOGIN.getPageURL();
        }

        Employee employee = optionalEmployee.get();

        String name = employee.getFirstName() + " " + employee.getLastName();
        String systemRole = String.valueOf(employee.getSystemRole());

        LOGGER.debug("User name - " + name);
        LOGGER.debug("System role - " + systemRole);

        request.setAttribute("login_status", "Login success");

        session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), name);
        session.setAttribute(StringConstant.CURRENT_SESSION_ROLE_KEY.getValue(), systemRole);

        return PageEnum.LOGIN.getPageURL();
    }
}
