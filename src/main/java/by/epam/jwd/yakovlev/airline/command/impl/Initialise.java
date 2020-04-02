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

public class Initialise implements Command {

    private static final Logger LOGGER = Logger.getLogger(LoginUser.class);
    //private static EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

/*        HttpSession session = request.getSession();
        Optional<Employee> optionalEmployee = Optional.empty();
        String user = StringConstant.GUEST.getValue();
        char[] password = StringConstant.EMPTY_STRING.getValue().toCharArray();

        try {
            optionalEmployee = EMPLOYEE_SERVICE.login(user, password);
        } catch (ServiceException e) {
            LOGGER.debug("Service failed " + e.getMessage());
            response.sendError(503, "Service unavailable");
        }

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

        return PageEnum.INDEX.getPageURL();*/

        HttpSession session = request.getSession();
        String userName = StringConstant.UNREGISTERED.getValue() +
                StringConstant.WHITE_SPACE.getValue() + StringConstant.USER.getValue();
        session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), userName);
        session.setAttribute(StringConstant.CURRENT_SESSION_ROLE_KEY.getValue(), StringConstant.ZERO.getValue());

        String nextPage = PageEnum.INDEX.getPageURL();

        return nextPage;
    }
}
