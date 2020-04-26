package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCrewRoleFactory extends AbstractDAOFactory<CrewRole> {
	
	@Override
	public CrewRole create(ResultSet resultSet) throws SQLException {
		
		CrewRole crewRole = new CrewRole();

        crewRole.setCrewRoleID(resultSet.getInt(StringConstant.CREW_ROLE_ID_KEY.getValue()));
        crewRole.setCrewRoleName(resultSet.getString(StringConstant.CREW_ROLE_NAME_KEY.getValue()));

        return crewRole;
	}
}