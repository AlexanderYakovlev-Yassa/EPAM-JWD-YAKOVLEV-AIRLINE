package by.epam.jwd.yakovlev.airline.tag.util.impl;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.tag.util.Converter;
import by.epam.jwd.yakovlev.airline.tag.util.ConverterValueExtractor;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.util.Properties;

public class EmployeeConverter implements Converter {

    private static final ConverterValueExtractor EXTRACTOR = ConverterValueExtractor.INSTANCE;

    @Override
    public Properties convertToProperties(Object o) {

        Properties properties = new Properties();

        if (o == null || o.getClass() != Employee.class) {
            return properties;
        }

        Employee employee = (Employee)o;

        properties.setProperty(StringConstant.EMPLOYEE_ID_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getId()));
        properties.setProperty(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getNickname()));
        properties.setProperty(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getFirstName()));
        properties.setProperty(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getLastName()));
        properties.setProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getSystemRole().getSystemRoleID()));
        properties.setProperty(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getSystemRole().getSystemRoleName()));
        properties.setProperty(StringConstant.CREW_ROLE_ID_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getCrewRole().getCrewRoleID()));
        properties.setProperty(StringConstant.CREW_ROLE_NAME_KEY.getValue(),
                EXTRACTOR.extractValue(employee.getCrewRole().getCrewRoleName()));

        return properties;
    }
}
