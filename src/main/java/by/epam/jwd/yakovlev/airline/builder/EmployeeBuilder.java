package by.epam.jwd.yakovlev.airline.builder;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.BuilderException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Properties;

public class EmployeeBuilder {

    private static final Logger logger = Logger.getLogger(EmployeeBuilder.class);

    public Optional<Employee> buildEmployee(Properties employeeProperties) throws BuilderException {

        Optional<Employee> optionalEmployee = Optional.empty();

        if (employeeProperties == null) {
            return optionalEmployee;
        }

        String firstName = employeeProperties.getProperty(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue());
        String lastName = employeeProperties.getProperty(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue());
        String nickname = employeeProperties.getProperty(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue());
        int id = 0;
        int systemRole = 0;
        int crewRole = 0;

        try {
            id = Integer.valueOf(employeeProperties.getProperty(StringConstant.EMPLOYEE_ID_KEY.getValue()));
            systemRole = Integer.valueOf(employeeProperties.getProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue()));
            crewRole = Integer.valueOf(employeeProperties.getProperty(StringConstant.CREW_ROLE_ID_KEY.getValue()));
        } catch (NumberFormatException e) {
            throw new BuilderException ("Fail to build an Employee", e);
        }

        Employee employee = new Employee();
        employee.setId(id);
        employee.setSystemRole(systemRole);
        employee.setCrewRole(crewRole);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setNickname(nickname);

        optionalEmployee = Optional.of(employee);

        return optionalEmployee;
    }
}
