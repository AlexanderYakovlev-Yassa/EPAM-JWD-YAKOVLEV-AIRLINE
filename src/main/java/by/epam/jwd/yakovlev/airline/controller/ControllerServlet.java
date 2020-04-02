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

    private static final Logger LOGGER = Logger.getLogger(ControllerServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConnectionsPool.INSTANCE.initializePool();
        } catch (AirlineDataBaseConnectionException e) {
            LOGGER.warn("Pool of connection is not initialise");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionsPool.INSTANCE.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Command command = getCommand(request, response);
        request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Command command = getCommand(request, response);

        request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
    }

    private Command getCommand(HttpServletRequest request, HttpServletResponse response) {

        Command command = null;
        HttpSession session = request.getSession( true);

        if (session.getAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue()) == null) {
            return CommandEnum.INITIALISE.getCommand();
        }

        String commandName = request.getParameter(StringConstant.COMMAND_KEY.getValue());

        if (commandName == null) {
            return CommandEnum.REFRESH_PAGE.getCommand();
        }

        for (CommandEnum c : CommandEnum.values()) {
            if (c.name().equals(commandName.toUpperCase())) {
                command = c.getCommand();
            }
        }

        LOGGER.debug("Controller servlet got the command " + commandName);
        return command;
    }
}