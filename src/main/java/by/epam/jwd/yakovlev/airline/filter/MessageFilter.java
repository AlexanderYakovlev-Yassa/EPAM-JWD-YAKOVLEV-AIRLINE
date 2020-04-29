package by.epam.jwd.yakovlev.airline.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class MessageFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		session.setAttribute(StringConstant.WARNING_MESSAGE_KEY.getValue(), 
				StringConstant.EMPTY_STRING.getValue());
		session.setAttribute(StringConstant.SUCCESS_MESSAGE_KEY.getValue(), 
				StringConstant.EMPTY_STRING.getValue());
		
		chain.doFilter(request, response);
	}
}
