package by.epam.jwd.yakovlev.airline.factory.commandfactory.impl;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;

public class CommandDefaultEmployeeFactory {

	private static final int DEFAULT_ID = 0;
	private static final String DEFAULT_NICKNAME = "unregistered";
	private static final String DEFAULT_FIRST_NAME = "Unregistered";
	private static final String DEFAULT_LAST_NAME = "User";
	private static final String DEFAULT_SYSTEM_ROLE_NAME = "unregistered";
	private static final String DEFAULT_CREW_ROLE_NAME = "guest";

	public Employee getDefaultEmployee() {

		Employee employee = new Employee();

		employee.setId(0);
		employee.setNickname(DEFAULT_NICKNAME);
		employee.setFirstName(DEFAULT_FIRST_NAME);
		employee.setLastName(DEFAULT_LAST_NAME);
		employee.setSystemRole(getDefaultSystemRole());
		employee.setCrewRole(getDefaultCrewRole());

		return employee;
	}

	private SystemRole getDefaultSystemRole() {

		SystemRole systemRole = new SystemRole();
		systemRole.setSystemRoleID(DEFAULT_ID);
		systemRole.setSystemRoleName(DEFAULT_SYSTEM_ROLE_NAME);

		return systemRole;
	}

	private CrewRole getDefaultCrewRole() {

		CrewRole crewRole = new CrewRole();
		crewRole.setCrewRoleID(DEFAULT_ID);
		crewRole.setCrewRoleName(DEFAULT_CREW_ROLE_NAME);

		return crewRole;
	}
}
