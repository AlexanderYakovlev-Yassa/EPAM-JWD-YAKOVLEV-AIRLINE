package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl;

import by.epam.jwd.yakovlev.airline.command.SystemRoleEnum;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DAOEmployeeFactory implements DAOEntityFactory {

    private static final Logger LOGGER = Logger.getLogger(DAOCrewRoleFactory.class);

    @Override
    public Optional<Object> make(ResultSet resultSet) throws SQLException {

        final EmployeeDAO EMPLOYEE_DAO = DAOFactory.INSTANCE.getEmployeeDAO();

        Employee employee = new Employee();

        employee.setId(resultSet.getInt(StringConstant.EMPLOYEE_ID_KEY.getValue()));
        employee.setNickname(resultSet.getString(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue()));
        employee.setFirstName(resultSet.getString(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue()));
        employee.setLastName(resultSet.getString(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue()));
        int systemRoleID = resultSet.getInt(StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
        int crewRoleID = resultSet.getInt(StringConstant.CREW_ROLE_ID_KEY.getValue());

        try {
            Optional<SystemRole> optionalSystemRole = EMPLOYEE_DAO.getSystemRoleByID(systemRoleID);
            Optional<CrewRole> optionalCrewRole = EMPLOYEE_DAO.getCrewRoleByID(crewRoleID);

            optionalSystemRole.ifPresent(employee::setSystemRole);
            optionalCrewRole.ifPresent(employee::setCrewRole);

        } catch (DaoException e) {
            LOGGER.warn("Fail get system role or crew role because " + e.getMessage());
        }

        return Optional.of(employee);
    }
}
