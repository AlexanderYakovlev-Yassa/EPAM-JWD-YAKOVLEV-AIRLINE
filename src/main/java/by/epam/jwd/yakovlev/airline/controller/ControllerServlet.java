package by.epam.jwd.yakovlev.airline.controller;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.CommandEnum;
import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;
import by.epam.jwd.yakovlev.airline.pool.ConnectionsPool;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	private static final Logger LOGGER = Logger.getLogger(ControllerServlet.class);	

	@Override
	public void init() throws ServletException {
		super.init();

		LOGGER.debug("Init is started");

		try {
			ConnectionsPool.INSTANCE.initializePool();
		} catch (AirlineDataBaseConnectionException e) {
			LOGGER.warn("Pool of connection is not initialise", e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();

		LOGGER.debug("Destroy is started");

		ConnectionsPool.INSTANCE.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("doGet is started");

		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");

		Command command = getCommand(request, response);

		LOGGER.debug("doGet got command " + command.getClass());
		request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.debug("doPost is started");

		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");

		Command command = getCommand(request, response);
		LOGGER.debug("doPost got command " + command.getClass());
		request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
	}

	private Command getCommand(HttpServletRequest request, HttpServletResponse response) {
		
		LOGGER.debug("getCommand is started");
		LOGGER.debug(
				"Controller servlet got the command " + request.getParameter(StringConstant.COMMAND_KEY.getValue()));
		
		String commandName = request.getParameter(StringConstant.COMMAND_KEY.getValue());
		if (commandName == null) {
			LOGGER.debug("command name is null. Return GOTO_PAGE_INDEX");
			return CommandEnum.INITIALISE.getCommand();
		}

		HttpSession session = request.getSession();

		session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), 
				StringConstant.EMPTY_STRING.getValue());
		session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), 
				StringConstant.EMPTY_STRING.getValue());

		Command command = null;
		for (CommandEnum c : CommandEnum.values()) {
			if (c.name().equals(commandName.toUpperCase())) {
				command = c.getCommand();
			}
		}

		return command;
	}
}