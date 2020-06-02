package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class GotoPageSelectFlight extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String currentPage = (String) session.getAttribute(StringConstant.CURRENT_PAGE.getValue());
		session.setAttribute(StringConstant.PREVIOUS_PAGE.getValue(), currentPage);		
		
		refreshTimePeriod(session);
		
		return PageEnum.SELECT_FLIGHT.getPageURL();
	}
}
