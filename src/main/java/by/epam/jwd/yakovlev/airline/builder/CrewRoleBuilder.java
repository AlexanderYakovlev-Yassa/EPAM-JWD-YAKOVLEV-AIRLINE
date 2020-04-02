package by.epam.jwd.yakovlev.airline.builder;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Properties;

public enum CrewRoleBuilder {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(CrewRoleBuilder.class);

    public Optional<CrewRole> build(Properties crewRoleProperties) {

        if (crewRoleProperties == null) {
            LOGGER.warn("There are no properties to build a crew role.");
            return Optional.empty();
        }

        String crewRoleIDString = crewRoleProperties.getProperty(
                StringConstant.CREW_ROLE_ID_KEY.getValue());
        String crewRoleIName = crewRoleProperties.getProperty(
                StringConstant.CREW_ROLE_NAME_KEY.getValue());

        int crewRoleID;

        try {
            crewRoleID = Integer.parseInt(crewRoleIDString);
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid crew role ID. " + crewRoleIDString);
            return Optional.empty();
        }

        CrewRole crewRole = new CrewRole();

        crewRole.setCrewRoleID(crewRoleID);
        crewRole.setCrewRoleName(crewRoleIName);

        return Optional.ofNullable(crewRole);
    }
}
