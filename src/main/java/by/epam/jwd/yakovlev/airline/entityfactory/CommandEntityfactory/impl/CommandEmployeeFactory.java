package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.impl;

import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.CommandEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.service.ServiceFactory;
import by.epam.jwd.yakovlev.airline.service.impl.EmployeeServiceImpl;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class CommandEmployeeFactory implements CommandEntityFactory {

	private static final Logger LOGGER = Logger.getLogger(CommandEmployeeFactory.class);
	private static final EmployeeService EMPLOYEE_SERVICE = ServiceFactory.INSTANCE.getEmployeeService();

	@Override
	public Optional<Object> create(Map<String, String[]> map) throws EntityFactoryException {
		
		if (map == null) {
			LOGGER.warn("Failed to create employee due to null input parameter");
			throw new EntityFactoryException("Failed to create employee due to null input parameter");
		}
		
		int employeeID = map.containsKey(StringConstant.EMPLOYEE_ID_KEY.getValue()) &&
				map.get(StringConstant.EMPLOYEE_ID_KEY.getValue())[0] != StringUtils.EMPTY ?
				Integer.parseInt(map.get(StringConstant.EMPLOYEE_ID_KEY.getValue())[0]) : 0;
				
		String nickname = map.containsKey(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue()) ?
				map.get(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue())[0] : StringUtils.EMPTY;
				
		String firstName = map.containsKey(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue()) ?
				map.get(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue())[0] : StringUtils.EMPTY;
				
		String lastName = map.containsKey(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue()) ?
				map.get(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue())[0] : StringUtils.EMPTY;
				
		String systemRoleIDString = map.containsKey(StringConstant.SYSTEM_ROLE_ID_KEY.getValue()) ?
				map.get(StringConstant.SYSTEM_ROLE_ID_KEY.getValue())[0] : StringUtils.EMPTY;
				
		String crewRoleIDString = map.containsKey(StringConstant.CREW_ROLE_ID_KEY.getValue()) ?
				map.get(StringConstant.CREW_ROLE_ID_KEY.getValue())[0] : StringUtils.EMPTY;				
		
		int systemRoleID = 0;
		int crewRoleID = 0;
		
		try {			
			systemRoleID = Integer.valueOf(systemRoleIDString);
			crewRoleID = Integer.valueOf(crewRoleIDString);
		} catch(NumberFormatException e) {
			LOGGER.debug("Can't convert ID to integer.\n sys-role-ID = " + systemRoleIDString + 
					"\ncrew-role-ID = " + crewRoleIDString);
		}
				
		Optional<SystemRole> systemRolreOptional = Optional.empty();
		Optional<CrewRole> crewRoleOptional = Optional.empty();
		try {
			systemRolreOptional = EMPLOYEE_SERVICE.getSystemRoleByID(systemRoleID);
			crewRoleOptional = EMPLOYEE_SERVICE.getCrewRoleByID(crewRoleID);
		} catch (ServiceException e) {
			LOGGER.debug("Fail to get system or crew role.\n sys-role-ID = " + systemRoleID +
					"\ncrew-role-ID = " + crewRoleID);
			throw new EntityFactoryException("Fail to get system or crew role", e);
		}
		
		Employee employee = new Employee();
		
		employee.setId(employeeID);
		employee.setNickname(nickname);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		systemRolreOptional.ifPresent(employee::setSystemRole);
		crewRoleOptional.ifPresent(employee::setCrewRole);
		
		Optional<Object> objectOptional = Optional.of(employee);
		
		LOGGER.debug("The raw employee created successfuly - " + employee.toString());
		
		return objectOptional;
	}
}
