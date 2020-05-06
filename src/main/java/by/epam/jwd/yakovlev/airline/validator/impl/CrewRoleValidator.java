package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class CrewRoleValidator extends AbstractValidator{	
	
	public void check(CrewRole crewRole) throws ValidatorException {
		
		checkName(crewRole.getCrewRoleName());
		checkNotNegativeInteger(crewRole.getCrewRoleID());		
	}
}
