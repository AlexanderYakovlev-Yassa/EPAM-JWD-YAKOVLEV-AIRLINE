package by.epam.jwd.yakovlev.airline.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.CommandEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class LegalCommandFilter implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger(LegalCommandFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String commandName = httpRequest.getParameter(StringConstant.COMMAND_KEY.getValue());
		HttpSession session = httpRequest.getSession();
		Object user = session.getAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue());
		
		if (commandName == null && user != null) {
			LOGGER.debug("NULL COMMAND");
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher dispatcher = servletContext
					.getRequestDispatcher(PageEnum.UNRECOGNIZED_COMMAND_PAGE.getPageURL());
			dispatcher.forward(request, response);
			return;
		}
		
		if (commandName == null && user == null) {
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher dispatcher = servletContext
					.getRequestDispatcher(CommandEnum.INITIALISE_SESSION.getCommand()
					.execute(httpRequest, httpResponse));
			dispatcher.forward(request, response);
			return;
		}
		
		boolean commandExists = false;
		for (CommandEnum ce: CommandEnum.values()) {
			if (ce.name().equals(commandName.toUpperCase())) {
				commandExists = true;
				break;
			}
		}
		
		if (!commandExists) {
			LOGGER.debug("UNRECOGNIZED COMMAND " + commandName);
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher dispatcher = servletContext
					.getRequestDispatcher(PageEnum.UNRECOGNIZED_COMMAND_PAGE.getPageURL());
			dispatcher.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}
}
