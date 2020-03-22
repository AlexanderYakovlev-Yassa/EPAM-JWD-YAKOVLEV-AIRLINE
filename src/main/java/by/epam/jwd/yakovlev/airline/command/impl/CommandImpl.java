package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.CommandEnum;
import by.epam.jwd.yakovlev.airline.command.LocalisationEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class CommandImpl implements Command {

    private static final String SYSTEM_ROLE_ATTRIBUTE_NAME = "system_role";
    private static final String DEFAULT_SYSTEM_ROLE_ATTRIBUTE_VALUE = "guest";
    private static final String LOCALISATION_ATTRIBUTE_NAME = "localisation";
    private static final String DEFAULT_LOCALISATION_ATTRIBUTE_VALUE = "en_US";
    private static final String NEXT_PAGE_ATTRIBUTE_VALUE = "next_page";
    private static final String CURRENT_PAGE_ATTRIBUTE_NAME = "current_page";
    private static final String COMMAND_ATTRIBUTE_NAME = "command";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, ServletContext context) {

        HttpSession session = request.getSession(true);
        String nextPage = PageEnum.INDEX.getPage();

        if (session.getAttribute(SYSTEM_ROLE_ATTRIBUTE_NAME) == null) {
            session.setAttribute(SYSTEM_ROLE_ATTRIBUTE_NAME, DEFAULT_SYSTEM_ROLE_ATTRIBUTE_VALUE);
        }

        if (session.getAttribute(LOCALISATION_ATTRIBUTE_NAME) == null) {
            session.setAttribute(LOCALISATION_ATTRIBUTE_NAME, DEFAULT_LOCALISATION_ATTRIBUTE_VALUE);
        }

        if (request.getParameter(COMMAND_ATTRIBUTE_NAME) == null) {
            return nextPage;
        }

        CommandEnum currentCommand = null;

        try {
            currentCommand = CommandEnum.valueOf(request.getParameter(COMMAND_ATTRIBUTE_NAME).toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            currentCommand = CommandEnum.NO_COMMAND;
        }

        switch (currentCommand) {
            case NO_COMMAND: {
                response.setStatus(404);
            }
            case SET_LANGUAGE: {
                nextPage = PageEnum.valueOf(request.getParameter("page").toUpperCase()).getPage();
                session.setAttribute(LOCALISATION_ATTRIBUTE_NAME,
                        LocalisationEnum.valueOf(request.getParameter("language").toUpperCase()).getLocalisation());
                break;
            }
            case LOGIN: {
                nextPage = PageEnum.LOGIN.getPage();
                break;
            }
            default: {
                //I don't know yet whether redirect into the same page or into an error page
            }

        }

        return nextPage;
    }

    private void printAttributes(ServletContext context) {
        Enumeration<String> names = context.getAttributeNames();
        String attrName;
        System.out.println(names.hasMoreElements());
        while (names.hasMoreElements()){
            attrName = names.nextElement();
            System.out.println(attrName + "=" + context.getAttribute(attrName));
        }
    }
}
