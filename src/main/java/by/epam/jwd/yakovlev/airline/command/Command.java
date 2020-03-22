package by.epam.jwd.yakovlev.airline.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response, ServletContext context);
}
