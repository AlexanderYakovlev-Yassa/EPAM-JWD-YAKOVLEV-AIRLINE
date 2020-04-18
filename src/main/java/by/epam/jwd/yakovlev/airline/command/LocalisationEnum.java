package by.epam.jwd.yakovlev.airline.command;

import java.util.Locale;

public enum LocalisationEnum {
    RU ("ru"),
    US ("en");

    String locale;

    LocalisationEnum(String locale) {
        this.locale = locale;
    }

    public String getLocalisation() {
        return locale;
    }
}
