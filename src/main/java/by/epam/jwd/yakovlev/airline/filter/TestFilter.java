package by.epam.jwd.yakovlev.airline.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class TestFilter implements Filter{
	
	
	private static final Logger LOGGER = Logger.getLogger("*******");

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("TestFilter");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;				
				
		Enumeration<String> names = httpRequest.getParameterNames();
		
		String parameterName;
		while (names.hasMoreElements()) {
			parameterName = names.nextElement();
			System.out.println(parameterName + " - " + httpRequest.getParameter(parameterName));
			LOGGER.debug(parameterName + " - " + httpRequest.getParameter(parameterName));
		}
		
		chain.doFilter(request, response);
	}
}
