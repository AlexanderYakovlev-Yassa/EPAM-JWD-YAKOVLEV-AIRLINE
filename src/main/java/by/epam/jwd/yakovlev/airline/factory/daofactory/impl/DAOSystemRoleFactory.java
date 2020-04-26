package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOSystemRoleFactory extends AbstractDAOFactory<SystemRole> {
    
	@Override
	public SystemRole create(ResultSet resultSet) throws SQLException {
		
		SystemRole systemRole = new SystemRole();

        systemRole.setSystemRoleID(resultSet.getInt(StringConstant.SYSTEM_ROLE_ID_KEY.getValue()));
        systemRole.setSystemRoleName(resultSet.getString(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue()));

        return systemRole;
	}
}
