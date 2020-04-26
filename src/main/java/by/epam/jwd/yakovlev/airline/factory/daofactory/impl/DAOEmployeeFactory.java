package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEmployeeFactory extends AbstractDAOFactory<Employee> {

    @Override
    public Employee create(ResultSet resultSet) throws SQLException {

        Employee employee = new Employee();

        employee.setId(resultSet.getInt(StringConstant.EMPLOYEE_ID_KEY.getValue()));
        employee.setNickname(resultSet.getString(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue()));
        employee.setFirstName(resultSet.getString(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue()));
        employee.setLastName(resultSet.getString(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue()));
        
        SystemRole systemRole = new SystemRole();
        
        systemRole.setSystemRoleID(resultSet.getInt(StringConstant.SYSTEM_ROLE_ID_KEY.getValue()));
        systemRole.setSystemRoleName(resultSet.getString(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue()));
        
        CrewRole crewRole = new CrewRole();
        
        crewRole.setCrewRoleID(resultSet.getInt(StringConstant.CREW_ROLE_ID_KEY.getValue()));
        crewRole.setCrewRoleName(resultSet.getString(StringConstant.CREW_ROLE_NAME_KEY.getValue()));

        employee.setSystemRole(systemRole);
        employee.setCrewRole(crewRole);
        
        return employee;
    }
}
