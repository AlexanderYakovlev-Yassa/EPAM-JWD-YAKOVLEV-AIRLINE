package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GotoPage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nextPageName = request.getParameter(StringConstant.PAGE_KEY.getValue()).toUpperCase();
        String nextPageURL = null;
        String currentPage = (String)request.getAttribute(StringConstant.CURRENT_PAGE.getValue());

        nextPageURL = PageEnum.getPageURL(nextPageName);

        if (nextPageURL == null) {
            nextPageName = PageEnum.getPageURL(currentPage);
        }

        if (nextPageURL == null) {
            nextPageName = PageEnum.INDEX.getPageURL();
        }

        return nextPageURL;
    }
}
