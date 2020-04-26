package by.epam.jwd.yakovlev.airline.command;

import java.util.Locale;

public enum LocalisationEnum {
    RU (new Locale("ru", "RU")),
    EN (new Locale("en", "EN"));

    Locale locale;

    LocalisationEnum(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocalisation() {
        return locale;
    }
}
