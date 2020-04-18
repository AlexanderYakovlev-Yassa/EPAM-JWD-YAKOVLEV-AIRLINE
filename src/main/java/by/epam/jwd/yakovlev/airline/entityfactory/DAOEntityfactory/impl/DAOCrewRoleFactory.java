package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DAOCrewRoleFactory implements DAOEntityFactory {

    private static final Logger LOGGER = Logger.getLogger(DAOCrewRoleFactory.class);

    @Override
    public Optional<Object> make(ResultSet resultSet) throws SQLException {

        CrewRole crewRole = new CrewRole();

        crewRole.setCrewRoleID(resultSet.getInt(StringConstant.CREW_ROLE_ID_KEY.getValue()));
        crewRole.setCrewRoleName(resultSet.getString(StringConstant.CREW_ROLE_NAME_KEY.getValue()));

        return Optional.of(crewRole);
    }
}