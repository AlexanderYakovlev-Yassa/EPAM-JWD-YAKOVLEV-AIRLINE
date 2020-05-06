package by.epam.jwd.yakovlev.airline.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;

public class GotoPageUnrecognizedCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		return PageEnum.UNRECOGNIZED_COMMAND_PAGE.getPageURL();
	}

}
