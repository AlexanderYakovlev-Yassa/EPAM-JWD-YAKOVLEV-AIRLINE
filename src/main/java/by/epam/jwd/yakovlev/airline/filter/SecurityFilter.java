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
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.command.CommandEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.command.SystemRoleEnum;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		int defaultUserSecurityIndex = 3;
		int defaultCommandSecurityIndex = 3;

		System.out.println("SecurityFilter");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		System.out.println("Security 1");
		Employee currentUser = (Employee) session.getAttribute(StringConstant.CURRENT_SESSION_USER_KEY.getValue());
		System.out.println("Security 2");
		String commandName = httpRequest.getParameter(StringConstant.COMMAND_KEY.getValue());
		System.out.println("Security 3");

		int currentUserSecurityIndex = currentUser != null
				? SystemRoleEnum.valueOf(currentUser.getSystemRole().getSystemRoleName().toUpperCase())
						.getSecurityIndex()
				: defaultUserSecurityIndex;

		int commandSecurityIndex = commandName != null
				? CommandEnum.valueOf(commandName.toUpperCase()).getSecurityIndex()
				: defaultCommandSecurityIndex;

		System.out.println("security currentUserSecurityIndex - " + currentUserSecurityIndex);
		System.out.println("security commandSecurityIndex - " + commandSecurityIndex);

		if (currentUserSecurityIndex > commandSecurityIndex) {
			System.out.println("security redirect");
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher dispatcher = servletContext
					.getRequestDispatcher(PageEnum.SECURITY_ALERT_PAGE.getPageURL());
			dispatcher.forward(request, response);
			return;
		}
		System.out.println("Security 5");
		chain.doFilter(request, response);
	}

}
