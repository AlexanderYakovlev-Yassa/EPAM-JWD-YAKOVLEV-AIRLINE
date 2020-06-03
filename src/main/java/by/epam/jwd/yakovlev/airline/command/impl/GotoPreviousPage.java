package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class GotoPreviousPage extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		try {
			return PageEnum
					.valueOf((((String) session.getAttribute(StringConstant.PREVIOUS_PAGE.getValue())).toUpperCase()))
					.getPageURL();
		} catch (IllegalArgumentException | NullPointerException e) {
			return PageEnum.INDEX.getPageURL();
		}
	}
}
