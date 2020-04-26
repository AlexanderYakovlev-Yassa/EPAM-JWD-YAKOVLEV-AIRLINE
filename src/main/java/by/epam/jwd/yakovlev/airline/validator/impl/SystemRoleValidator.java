package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class SystemRoleValidator extends AbstractValidator{
	
	
	public void check(SystemRole systemRole) throws ValidatorException {
		
		checkName(systemRole.getSystemRoleName());
		checkNotNegativeInteger(systemRole.getSystemRoleID());		
	}
}
