package by.epam.jwd.yakovlev.airline.tag.util;

public enum  ConverterValueExtractor {
    INSTANCE;

    private static final String NO_DATA = "no data";
    private static final String UNSUPPORTED_DATA = "unsupported data";

    public String extractValue(Object o) {

        if (o == null) {
            return NO_DATA;
        }

        if (!(o instanceof Number) && !(o.getClass() == String.class)) {
            return UNSUPPORTED_DATA;
        }

        return  String.valueOf(o);
    }
}
