package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import java.util.Map;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.AbstractCommandEntityFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandCrewRoleFactory extends AbstractCommandEntityFactory<CrewRole>{
	
	private static final int ZERO_INDEX = 0;

	@Override
	public CrewRole create(Map<String, String[]> map) throws EntityFactoryException {
		
		CrewRole crewRole = new CrewRole();
		
		crewRole.setCrewRoleID
		(parseToPositiveIntOrElseZero(map.get(StringConstant.CREW_ROLE_ID_KEY.getValue())[ZERO_INDEX]));	
		
		crewRole.setCrewRoleName(map.get(StringConstant.CREW_ROLE_NAME_KEY.getValue())[ZERO_INDEX]);		
		
		return crewRole;
	}
}
