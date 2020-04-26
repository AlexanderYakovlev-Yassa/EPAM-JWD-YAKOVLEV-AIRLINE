package by.epam.jwd.yakovlev.airline.command.impl;

import by.epam.jwd.yakovlev.airline.command.Command;
import by.epam.jwd.yakovlev.airline.command.PageEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Home implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return PageEnum.INDEX.getPageURL();
    }
}
