package by.epam.jwd.yakovlev.airline.validator;

import java.util.regex.Pattern;

public enum RegexPatterns {
    NAME("^[A-ZА-ЯЁ][a-zа-яё]*$"),
    WORD ("^[//w]+$");

    private String regex;

    RegexPatterns(String regex) {
        this.regex = regex;
    }

    public Pattern getPattern() {
        return Pattern.compile(regex);
    }
}
