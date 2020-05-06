package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class EmployeeValidator extends AbstractValidator{
	
	public void check(Employee employee) throws ValidatorException {
		
		checkObjectIsNotNull(employee);
		checkNotNegativeInteger(employee.getId());
		checkName(employee.getFirstName());
		checkName(employee.getLastName());
		checkWord(employee.getNickname());
		checkObjectIsNotNull(employee.getSystemRole());
		checkObjectIsNotNull(employee.getCrewRole());		
	}
}
