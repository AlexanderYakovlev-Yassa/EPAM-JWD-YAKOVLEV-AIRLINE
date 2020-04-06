package by.epam.jwd.yakovlev.airline.tag.util.impl;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.tag.util.Converter;
import by.epam.jwd.yakovlev.airline.tag.util.ConverterValueExtractor;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.util.Properties;

public class CrewRoleConverter implements Converter {

    private static final ConverterValueExtractor EXTRACTOR = ConverterValueExtractor.INSTANCE;

    @Override
    public Properties convertToProperties(Object o) {

        Properties properties = new Properties();

        if (o == null || o.getClass() != CrewRole.class) {
            return properties;
        }

        CrewRole systemRole = (CrewRole) o;

        properties.setProperty(StringConstant.CREW_ROLE_ID_KEY.getValue(),
                EXTRACTOR.extractValue(systemRole.getCrewRoleID()));
        properties.setProperty(StringConstant.CREW_ROLE_NAME_KEY.getValue(),
                EXTRACTOR.extractValue(systemRole.getCrewRoleName()));

        return properties;
    }
}
