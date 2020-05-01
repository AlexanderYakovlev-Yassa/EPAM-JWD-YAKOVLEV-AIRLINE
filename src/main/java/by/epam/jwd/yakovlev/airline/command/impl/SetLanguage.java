package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.LocalisationEnum;
import by.epam.jwd.yakovlev.airline.command.PageEnum;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SetLanguage extends Command {

    private static final Logger LOGGER = Logger.getLogger(SetLanguage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        LOGGER.debug("Start command SET LANGUAGE");
        String nextPage;

        nextPage = PageEnum.valueOf
                (request.getParameter(StringConstant.PAGE_KEY.getValue()).toUpperCase()).getPageURL();

        String localisation = request.getParameter(StringConstant.LANGUAGE_KEY.getValue()).toUpperCase();
        HttpSession session = request.getSession();
        session.setAttribute(StringConstant.LOCALISATION_ATTRIBUTE_NAME.getValue(),
                LocalisationEnum.valueOf(localisation).getLocalisation());

        return nextPage;
    }
}
