package by.epam.jwd.yakovlev.airline.tag.util.impl;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.tag.util.Converter;
import by.epam.jwd.yakovlev.airline.tag.util.ConverterValueExtractor;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.util.Properties;

public class SystemRoleConverter implements Converter {

    private static final ConverterValueExtractor EXTRACTOR = ConverterValueExtractor.INSTANCE;

    @Override
    public Properties convertToProperties(Object o) {

        Properties properties = new Properties();

        if (o == null || o.getClass() != SystemRole.class) {
            return properties;
        }

        SystemRole systemRole = (SystemRole)o;

        properties.setProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue(),
                EXTRACTOR.extractValue(systemRole.getSystemRoleID()));
        properties.setProperty(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue(),
                EXTRACTOR.extractValue(systemRole.getSystemRoleName()));

        return properties;
    }
}
