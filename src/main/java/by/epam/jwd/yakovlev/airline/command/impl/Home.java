package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.AbstractCommand;
import by.epam.jwd.yakovlev.airline.command.PageEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Home extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return PageEnum.INDEX.getPageURL();
    }
}
