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
		
		Command command = getCommand(request, response);
		request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Command command = getCommand(request, response);
		request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
	}	

	private Command getCommand(HttpServletRequest request, HttpServletResponse response) {
		
		String commandName = request.getParameter(StringConstant.COMMAND_KEY.getValue());
		
		return CommandEnum.valueOf(commandName.toUpperCase()).getCommand();
	}
}