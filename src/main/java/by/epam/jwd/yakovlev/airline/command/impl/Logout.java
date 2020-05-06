package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.impl.CommandDefaultEmployeeFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class Logout extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		CommandDefaultEmployeeFactory defaultEmployeeFactory = CommandEntityFactory.getInstance().getDefaultEmployeeFactory();
		
		Employee defaultEmployee = defaultEmployeeFactory.getDefaultEmployee();

		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		session.setAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue(), defaultEmployee);
		return PageEnum.INDEX.getPageURL();
	}
}
