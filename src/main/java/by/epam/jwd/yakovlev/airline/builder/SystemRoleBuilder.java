package by.epam.jwd.yakovlev.airline.builder;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.BuilderException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Properties;

public enum SystemRoleBuilder {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(SystemRoleBuilder.class);

    public Optional<SystemRole> build(Properties systemRoleProperties) {

        if (systemRoleProperties == null) {
            LOGGER.warn("There are no properties to build a system role.");
            return Optional.empty();
        }

        String systemRoleIDString = systemRoleProperties.getProperty(
                StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
        String systemRoleIName = systemRoleProperties.getProperty(
                StringConstant.SYSTEM_ROLE_NAME_KEY.getValue());

        int systemRoleID;

        try {
            systemRoleID = Integer.parseInt(systemRoleIDString);
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid system role ID. " + systemRoleIDString);
            return Optional.empty();
        }

        SystemRole systemRole = new SystemRole();

        systemRole.setSystemRoleID(systemRoleID);
        systemRole.setSystemRoleName(systemRoleIName);

        return Optional.of(systemRole);
    }
}
