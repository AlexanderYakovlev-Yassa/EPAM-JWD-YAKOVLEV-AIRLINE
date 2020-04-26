package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManageEmployees implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	HttpSession session = request.getSession();
    	CommandUtil util = CommandUtil.getINSTANCE();

        util.refreshAllEmployeesList(session);
        util.refreshAllRolesList(session);

        return PageEnum.EMPLOYEE.getPageURL();
    }
}
