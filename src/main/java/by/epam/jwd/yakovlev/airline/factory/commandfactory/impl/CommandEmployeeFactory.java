package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.factory.commandfactory.AbstractCommandEntityFactory;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandEmployeeFactory extends AbstractCommandEntityFactory<Employee>{
	
	private static final Logger LOGGER = Logger.getLogger(CommandEmployeeFactory.class);
	private static final int ZERO_INDEX = 0;

	@Override
	public Employee create(Map<String, String[]> map) throws EntityFactoryException {
		
		Employee employee = new Employee();
		
		employee.setId
		(parseToPositiveIntOrElseZero(map.get(StringConstant.EMPLOYEE_ID_KEY.getValue())[ZERO_INDEX]));	
		
		employee.setNickname(map.get(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue())[ZERO_INDEX]);
		employee.setFirstName(map.get(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue())[ZERO_INDEX]);
		employee.setLastName(map.get(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue())[ZERO_INDEX]);
		
		int systemRoleID = parseToPositiveIntOrElseZero(map.get(StringConstant.SYSTEM_ROLE_ID_KEY.getValue())[ZERO_INDEX]);
		int crewRoleID = parseToPositiveIntOrElseZero(map.get(StringConstant.CREW_ROLE_ID_KEY.getValue())[ZERO_INDEX]);
		
		try {
			ServiceFactory.INSTANCE.getSystemRoleService().getSystemRoleByID(systemRoleID).ifPresent(employee::setSystemRole);
			ServiceFactory.INSTANCE.getCrewRoleService().getCrewRoleByID(crewRoleID).ifPresent(employee::setCrewRole);
		} catch (ServiceException e) {
			LOGGER.debug("Fail get employee components", e);
		}		
		
		return employee;
	}
}
