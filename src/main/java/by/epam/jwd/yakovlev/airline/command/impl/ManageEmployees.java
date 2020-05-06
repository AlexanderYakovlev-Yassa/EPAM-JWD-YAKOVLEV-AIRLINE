package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManageEmployees extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();

        refreshAllEmployeesList(session);
        refreshAllRolesList(session);

        return PageEnum.EMPLOYEE.getPageURL();
    }
}
