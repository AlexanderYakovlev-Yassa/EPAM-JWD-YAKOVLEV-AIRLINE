package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl;

import by.epam.jwd.yakovlev.airline.dao.impl.EmployeeDAOImpl;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DAOSystemRoleFactory implements DAOEntityFactory {

    private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);

    @Override
    public Optional<Object> make(ResultSet resultSet) throws SQLException {

        SystemRole systemRole = new SystemRole();

        systemRole.setSystemRoleID(resultSet.getInt(StringConstant.SYSTEM_ROLE_ID_KEY.getValue()));
        systemRole.setSystemRoleName(resultSet.getString(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue()));

        return Optional.of(systemRole);
    }
}
