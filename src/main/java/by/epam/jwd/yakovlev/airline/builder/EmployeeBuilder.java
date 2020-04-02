package by.epam.jwd.yakovlev.airline.builder;

import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Properties;

public enum EmployeeBuilder {
    INSTANCE;

    private static EmployeeDAO EMPLOYEE_DAO = DAOFactory.INSTANCE.getEmployeeDAO();
    private static final Logger LOGGER = Logger.getLogger(EmployeeBuilder.class);

    public Optional<Employee> build(Properties employeeProperties) {

        if (employeeProperties == null) {
            LOGGER.warn("There are no properties to build an employee.");
            return Optional.empty();
        }

        String employeeFirstName = employeeProperties.getProperty(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue());
        String employeeLastName = employeeProperties.getProperty(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue());
        String employeeNickname = employeeProperties.getProperty(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue());
        String employeeIDString = employeeProperties.getProperty(StringConstant.EMPLOYEE_ID_KEY.getValue());
        String employeeSystemRoleIDString = employeeProperties.getProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
        String employeeCrewRoleIDString = employeeProperties.getProperty(StringConstant.CREW_ROLE_ID_KEY.getValue());

        int employeeID = 0;
        int employeeSystemRoleID = 0;
        int employeeCrewRoleID = 0;

        try {
            employeeID = Integer.valueOf(employeeIDString);
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid employee ID. " + employeeIDString);
            return Optional.empty();
        }

        employeeSystemRoleID = Integer.valueOf(employeeSystemRoleIDString);
        Optional<SystemRole> optionalSystemRole = null;
        try {
            optionalSystemRole = EMPLOYEE_DAO.getSystemRoleByID(employeeSystemRoleID);
        } catch (DaoException e) {
            LOGGER.warn("Can't get a system role because  " + e.getMessage());
            return Optional.empty();
        }
        if (!optionalSystemRole.isPresent()) {
            LOGGER.warn("Empty system role.");
            return Optional.empty();
        }

        LOGGER.debug("employee crew role ID = " + employeeCrewRoleIDString);
        employeeCrewRoleID = Integer.valueOf(employeeCrewRoleIDString);
        Optional<CrewRole> optionalCrewRole;
        try {
            optionalCrewRole = EMPLOYEE_DAO.getCrewRoleByID(employeeCrewRoleID);
        } catch (DaoException e) {
            return Optional.empty();
        }
        if (!optionalCrewRole.isPresent()) {
            LOGGER.warn("Empty crew role.");
            return Optional.empty();
        }

        Employee employee = new Employee();

        employee.setId(employeeID);
        employee.setSystemRole(optionalSystemRole.get());
        employee.setCrewRole(optionalCrewRole.get());
        employee.setFirstName(employeeFirstName);
        employee.setLastName(employeeLastName);
        employee.setNickname(employeeNickname);

        return Optional.of(employee);
    }
}