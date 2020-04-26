package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import java.util.Map;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.AbstractCommandEntityFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandSystemRoleFactory extends AbstractCommandEntityFactory<SystemRole>{
	
	private static final int ZERO_INDEX = 0;

	@Override
	public SystemRole create(Map<String, String[]> map) throws EntityFactoryException {
		
		SystemRole systemRole = new SystemRole();
		
		systemRole.setSystemRoleID
		(parseToPositiveIntOrElseZero(map.get(StringConstant.SYSTEM_ROLE_ID_KEY.getValue())[ZERO_INDEX]));	
		
		systemRole.setSystemRoleName(map.get(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue())[ZERO_INDEX]);		
		
		return systemRole;
	}
}
